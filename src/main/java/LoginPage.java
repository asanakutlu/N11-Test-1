import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    By loginPath=By.cssSelector(".btnSignIn");
    By emailInput=By.xpath("//*[@data-required-message='Lütfen e-posta adresinizi girin.']");
    String email="testasanakutlu@gmail.com";
    By passworInput=By.xpath("//*[@data-validation='required minlength maxlength']");
    String pasword="Test.123";
    By loginButton=By.cssSelector("#loginButton");
    String Account="";
    By AccountPath=By.xpath("//*[@class='myAccount']/a[1]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void getLoginPage() throws InterruptedException {
        moveToElement(loginPath);
    }
    public void setUser(Logger logger) throws InterruptedException {
        setValue(emailInput,email);
        logger.info("email girisi yapıldı");

        setValue(passworInput,pasword);
        logger.info("sifre girildi");
        waitBySecond(5);
        inputEnter(loginButton);
        waitBySecond(5);
        Account=driver.findElement(AccountPath).getText();
        Assert.assertEquals("Giriş yapılırken hata oluştu !!","Hesabım",Account);

        logger.info("Giriş İşlemi Başarılı !");
    }
}
