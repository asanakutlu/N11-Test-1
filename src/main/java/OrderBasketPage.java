import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderBasketPage extends BasePage {
    By order=By.cssSelector(".myBasket ");
    By productPricecart=By.xpath("//div[@class='priceArea']//span");
    By orderPlus=By.cssSelector(".spinnerUp spinnerArrow");
    By orderDelete=By.xpath("//span[@class='removeProd svgIcon svgIcon_trash']");


    By orderEmpty=By.xpath("//div[@class='cartEmptyText']/h2");
    String orderEmptyText="";
    String priceCart="";
    ProductsPage productsPage=new ProductsPage(driver);
    public OrderBasketPage(WebDriver driver) {super(driver);}

    public void  orderCart(Logger logger) throws InterruptedException {
        logger.info("Sepet açıldı");
        click(order);
        waitBySecond(5);
        priceCart=driver.findElement(productPricecart).getText();
        logger.info(priceCart);
        waitBySecond(5);
        Assert.assertEquals("Fiyat eşleşmedi",productsPage.price,priceCart);
        logger.info("Fiyat eşleştirildi");
        click(orderPlus);
        waitBySecond(5);
        logger.info("Ürün adeti attırıldı.");
        WebElement number=driver.findElement(By.xpath("//div[@class='spinnerField ']//input"));
        String adet=number.getAttribute("value");
        Assert.assertEquals("Adet eşleşmedi","2",adet);
        logger.info("Adet eşleştirildi");
        click(orderDelete);
        logger.info("Ürün sepetten silindi");
        waitBySecond(5);

        orderEmptyText=driver.findElement(orderEmpty).getText();
        Assert.assertEquals("Sepet boşaltılamadı","Sepetiniz Boş",orderEmptyText);
        logger.info("Sepette ürün bulunmamaktadır");
    }
}
