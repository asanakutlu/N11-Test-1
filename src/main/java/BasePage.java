import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void click(By element) throws InterruptedException {
        waitBySecond(5);
        WebElement secici=driver.findElement(element);
        secici.click();
        waitBySecond(5);
    }
    public void setValue(By element,String setText) throws InterruptedException {
        WebElement secici=driver.findElement(element);
        secici.click();
        waitBySecond(5);
        secici.sendKeys(setText);

    }
    public void waitBySecond(Integer key) throws InterruptedException  {

        Thread.sleep(key*1000);
    }
    public void moveToElement(By byElement) throws InterruptedException{
        waitBySecond(5);
        WebElement element = this.driver.findElement(byElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        waitBySecond(5);
    }
    public void inputEnter(By byElement){
        WebElement element=driver.findElement(byElement);
        element.sendKeys(Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100000)");

    }

}
