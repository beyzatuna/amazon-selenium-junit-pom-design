import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("add-to-cart-button");
    By attachClose = By.id("attach-close_sideSheet-link");
    By cartCountLocator = By.id("nav-cart-count");
    By cartContainerLocator = By.id("nav-cart-count-container");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }


    public void attachClose() {
        click(attachClose);
    }


    public boolean isProductCountUp() {
        return getCartCount() > 0 ;
    }


    public int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void goToCart() {
        click(cartContainerLocator);
    }
}
