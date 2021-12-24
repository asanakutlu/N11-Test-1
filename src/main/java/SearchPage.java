import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    By inputSearch= By.id("searchData");
    By moreProducts=By.xpath("//div[@class='pagination']/a[2]");

    String searchProduct="bilgisayar";
    public SearchPage(WebDriver driver) {super(driver);}

    public void setInputSearch(Logger logger) throws InterruptedException {
        setValue(inputSearch,searchProduct);
        logger.info("Ürün ismi girildi.");
        inputEnter(inputSearch);
        logger.info("Ürün arandı");
        click(moreProducts);
        logger.info("İkinci sayfaya tıklandı.");
    }
}
