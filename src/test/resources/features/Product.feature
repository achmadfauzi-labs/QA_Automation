Feature: Product page functionality for Sauce Demo application

  Background: Login to Sauce Demo application
    Given I am on the Sauce Demo login page
    When I enter valid "standard_user" and "secret_sauce"
    And I click the login button
    Then I should be redirected to the product page "https://www.saucedemo.com/inventory.html"

  Scenario: Verify product page title after successful login
    Then I should see the product page title "Products"

  Scenario: Verify product items are displayed
    Then I should see the product items listed

  Scenario: Verify total number of products
    Then I should see 6 products on the page

  Scenario: Sort products by Name A to Z
    When I sort products by "Name (A to Z)"
    Then products should be sorted by name ascending

  Scenario: Sort products by Name Z to A
    When I sort products by "Name (Z to A)"
    Then products should be sorted by name descending

  Scenario: Sort products by price low to high
    When I sort products by "Price (low to high)"
    Then products should be sorted by price low to high

  Scenario: Sort products by price high to low
    When I sort products by "Price (high to low)"
    Then products should be sorted by price high to low

  Scenario: Add single item to cart
    When I add product at index 0 to cart
    Then the cart badge should show 1

  Scenario: Add multiple items to cart
    When I add product at index 0 to cart
    And I add product at index 1 to cart
    And I add product at index 2 to cart
    Then the cart badge should show 3

  Scenario: Navigate to shopping cart
    When I add product at index 0 to cart
    And I click on the shopping cart
    Then I should be on the cart page
    And the cart should contain 1 items

  Scenario: Logout from product page
    When I logout from the application
    Then I should still be on the login page
