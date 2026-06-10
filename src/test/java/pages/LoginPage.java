package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    // Error close button (X button on error message)
    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement errorCloseButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyRedirectionToProductPage(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Redirection failed. Expected URL: " + expectedUrl + ", but got: " + actualUrl);
        }
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeErrorMessage() {
        if (isErrorMessageDisplayed()) {
            errorCloseButton.click();
        }
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/");
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}
