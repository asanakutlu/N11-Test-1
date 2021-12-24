import org.junit.jupiter.api.Test;

public class N11Test extends BaseTest {
    LoginPage  loginPage=new LoginPage(driver);
    SearchPage searchPage=new SearchPage(driver);
    ProductsPage productsPage=new ProductsPage(driver);
    OrderBasketPage orderBasket=new OrderBasketPage(driver);

    @Test
    public void startTest() throws InterruptedException {

        loginPage.getLoginPage();
        loginPage.setUser(logger);
        searchPage.setInputSearch(logger);
        productsPage.randomSelectProduct(logger);
        productsPage.productDetails(logger);
        orderBasket.orderCart(logger);

    }
}
