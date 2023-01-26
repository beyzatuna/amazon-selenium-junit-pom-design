import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;



public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;

    @Test
    @Order(1)
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Not on products page!");
    }

    @Test
    @Order(2)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }

    @Test
    @Order(3)
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage.addToCart();
        Thread.sleep(2000);
        productDetailPage.attachClose();
        Assertions.assertTrue(productDetailPage.isProductCountUp(),
                "Product count did not increase!");
        productDetailPage.goToCart();
    }

    @Test
    @Order(4)
    public void go_To_Cart() {
        cartPage = new CartPage(driver);
    }

}
