package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static hooks.Hooks.driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartStep {

    CartPage cartPage;

    @Then("I should be on the cart page")
    public void iShouldBeOnTheCartPage() {
        cartPage = new CartPage(driver);
        assertEquals("Your Cart", cartPage.getPageTitle().trim());
    }

    @Then("the cart should contain {int} items")
    public void theCartShouldContainItems(int expectedCount) {
        cartPage = new CartPage(driver);
        assertEquals("Cart item count mismatch", expectedCount, cartPage.getCartItemCount());
    }

    @Then("{string} should be in the cart")
    public void productShouldBeInTheCart(String productName) {
        cartPage = new CartPage(driver);
        assertTrue(productName + " not found in cart", cartPage.isItemInCart(productName));
    }

    @When("I remove item at index {int} from cart")
    public void iRemoveItemAtIndexFromCart(int index) {
        cartPage = new CartPage(driver);
        cartPage.removeItemFromCart(index);
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        cartPage = new CartPage(driver);
        assertTrue("Cart should be empty", cartPage.isCartEmpty());
    }

    @When("I click continue shopping")
    public void iClickContinueShopping() {
        cartPage = new CartPage(driver);
        cartPage.clickContinueShopping();
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        cartPage = new CartPage(driver);
        cartPage.clickCheckout();
    }
}
