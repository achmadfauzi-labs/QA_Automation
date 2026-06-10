package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import static org.junit.Assert.*;
import static hooks.Hooks.driver;

public class LoginStep {

    LoginPage loginPage;

    @Given("I am on the Sauce Demo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid {string} and {string}")
    public void iEnterValidAnd(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the product page {string}")
    public void iShouldBeRedirectedToTheProductPage(String expectedUrl) {
        loginPage.verifyRedirectionToProductPage(expectedUrl);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        assertTrue("Error message should be displayed", loginPage.isErrorMessageDisplayed());
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("I should still be on the login page")
    public void iShouldStillBeOnTheLoginPage() {
        assertTrue("Should remain on login page", loginPage.isOnLoginPage());
    }

    @Then("the login button should be visible")
    public void theLoginButtonShouldBeVisible() {
        assertTrue("Login button should be visible", loginPage.isLoginButtonDisplayed());
    }
}
