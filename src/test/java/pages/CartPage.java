package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> cartItemNames;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[contains(@data-test,'remove')]")
    private List<WebElement> removeButtons;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public boolean isItemInCart(String productName) {
        return cartItemNames.stream()
                .anyMatch(el -> el.getText().equalsIgnoreCase(productName));
    }

    public void removeItemFromCart(int index) {
        if (index < removeButtons.size()) {
            removeButtons.get(index).click();
        }
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }
}
