import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ProductsPage extends BasePage{
    By pricePath=By.xpath("//div[@class='priceDetail']//ins");
    By addToCart=By.xpath("//div[@class='product-add-cart']//a");
    public static String price="";
    public ProductsPage(WebDriver driver) {super(driver);}
    public void randomSelectProduct(Logger logger){
        Random random = new Random();
        int randomProduct = random.nextInt(10) + 1;
        WebElement selectProduct=driver.findElement(By.xpath("//div[@id='view']//ul[@class='clearfix']//li[@class='column ']["+randomProduct+"]//img"));


        selectProduct.click();
        logger.info("Rastgele 1 ürün seçildi ve tıklanıldı.");
    }
    public void productDetails(Logger logger) throws InterruptedException {
        waitBySecond(4);
        price = driver.findElement(pricePath).getAttribute("content");
        System.out.println(price);
        click(addToCart);
        logger.info("Sepete eklendi");
        waitBySecond(5);
    }
}
