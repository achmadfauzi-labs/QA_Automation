package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement productTitle;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productItems;

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productNames;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartBadge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== TITLE =====
    public void verifyProductPageTitle(String expectedTitle) {
        String actualTitle = productTitle.getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Product page title does not match. Expected: "
                    + expectedTitle + ", but got: " + actualTitle);
        }
    }

    public String getPageTitle() {
        return productTitle.getText();
    }

    // ===== PRODUCT ITEMS =====
    // BUG FIX: List<WebElement> tidak punya .isDisplayed(), harus cek isEmpty()
    public void verifyProductItemsListed() {
        if (productItems.isEmpty()) {
            throw new AssertionError("Product items are not listed on the product page.");
        }
    }

    public int getProductCount() {
        return productItems.size();
    }

    public boolean isProductDisplayed(String productName) {
        return productNames.stream()
                .anyMatch(el -> el.getText().equalsIgnoreCase(productName));
    }

    // ===== SORTING =====
    public void sortProductsBy(String sortOption) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(sortOption);
    }

    public List<String> getProductNamesList() {
        return productNames.stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> getProductPricesList() {
        return productPrices.stream()
                .map(el -> Double.parseDouble(el.getText().replace("$", "")))
                .toList();
    }

    // ===== CART =====
    public void addItemToCartByIndex(int index) {
        // Each inventory item has an "Add to cart" button
        List<WebElement> addButtons = driver.findElements(
                By.xpath("//button[contains(@data-test,'add-to-cart')]"));
        if (index < addButtons.size()) {
            addButtons.get(index).click();
        } else {
            throw new AssertionError("Product index " + index + " does not exist.");
        }
    }

    public void addItemToCartByName(String productName) {
        // Convert product name to data-test attribute format
        String dataTest = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        WebElement btn = driver.findElement(By.xpath("//button[@data-test='" + dataTest + "']"));
        btn.click();
    }

    public int getCartItemCount() {
        try {
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public void clickShoppingCart() {
        shoppingCartIcon.click();
    }

    // ===== LOGOUT =====
    public void logout() {
        hamburgerMenu.click();
        // Wait briefly for menu animation
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        logoutLink.click();
    }

    public boolean isOnProductPage() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
}
