package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import java.util.List;
import static org.junit.Assert.*;
import static hooks.Hooks.driver;

public class ProductStep {

    // BUG FIX: Harus diinisialisasi dengan driver, bukan null
    ProductPage productPage = new ProductPage(driver);

    @And("I should see the product page title {string}")
    public void iShouldSeeTheProductPageTitle(String expectedTitle) {
        productPage = new ProductPage(driver);
        productPage.verifyProductPageTitle(expectedTitle);
    }

    @And("I should see the product items listed")
    public void iShouldSeeTheProductItemsListed() {
        productPage = new ProductPage(driver);
        productPage.verifyProductItemsListed();
    }

    @Then("I should see {int} products on the page")
    public void iShouldSeeProductsOnThePage(int expectedCount) {
        productPage = new ProductPage(driver);
        int actualCount = productPage.getProductCount();
        assertEquals("Product count mismatch", expectedCount, actualCount);
    }

    @When("I sort products by {string}")
    public void iSortProductsBy(String sortOption) {
        productPage = new ProductPage(driver);
        productPage.sortProductsBy(sortOption);
    }

    @Then("products should be sorted by name ascending")
    public void productsShouldBeSortedByNameAscending() {
        productPage = new ProductPage(driver);
        List<String> names = productPage.getProductNamesList();
        List<String> sorted = names.stream().sorted().toList();
        assertEquals("Products are not sorted A-Z", sorted, names);
    }

    @Then("products should be sorted by name descending")
    public void productsShouldBeSortedByNameDescending() {
        productPage = new ProductPage(driver);
        List<String> names = productPage.getProductNamesList();
        List<String> sorted = names.stream().sorted((a, b) -> b.compareTo(a)).toList();
        assertEquals("Products are not sorted Z-A", sorted, names);
    }

    @Then("products should be sorted by price low to high")
    public void productsShouldBeSortedByPriceLowToHigh() {
        productPage = new ProductPage(driver);
        List<Double> prices = productPage.getProductPricesList();
        List<Double> sorted = prices.stream().sorted().toList();
        assertEquals("Products are not sorted low to high", sorted, prices);
    }

    @Then("products should be sorted by price high to low")
    public void productsShouldBeSortedByPriceHighToLow() {
        productPage = new ProductPage(driver);
        List<Double> prices = productPage.getProductPricesList();
        List<Double> sorted = prices.stream().sorted((a, b) -> Double.compare(b, a)).toList();
        assertEquals("Products are not sorted high to low", sorted, prices);
    }

    @When("I add product at index {int} to cart")
    public void iAddProductAtIndexToCart(int index) {
        productPage = new ProductPage(driver);
        productPage.addItemToCartByIndex(index);
    }

    @When("I add {string} to cart")
    public void iAddProductToCart(String productName) {
        productPage = new ProductPage(driver);
        productPage.addItemToCartByName(productName);
    }

    @Then("the cart badge should show {int}")
    public void theCartBadgeShouldShow(int expectedCount) {
        productPage = new ProductPage(driver);
        int actualCount = productPage.getCartItemCount();
        assertEquals("Cart badge count mismatch", expectedCount, actualCount);
    }

    @When("I click on the shopping cart")
    public void iClickOnTheShoppingCart() {
        productPage = new ProductPage(driver);
        productPage.clickShoppingCart();
    }

    @When("I logout from the application")
    public void iLogoutFromTheApplication() {
        productPage = new ProductPage(driver);
        productPage.logout();
    }

    @Then("I should be on the product page")
    public void iShouldBeOnTheProductPage() {
        productPage = new ProductPage(driver);
        assertTrue("Should be on product page", productPage.isOnProductPage());
    }
}
