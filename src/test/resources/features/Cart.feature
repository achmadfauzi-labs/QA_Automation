Feature: Shopping cart functionality for Sauce Demo application

  Background: Login and add items to cart
    Given I am on the Sauce Demo login page
    When I enter valid "standard_user" and "secret_sauce"
    And I click the login button
    Then I should be redirected to the product page "https://www.saucedemo.com/inventory.html"

  Scenario: View cart after adding item
    When I add product at index 0 to cart
    And I click on the shopping cart
    Then I should be on the cart page
    And the cart should contain 1 items

  Scenario: Remove item from cart
    When I add product at index 0 to cart
    And I click on the shopping cart
    And I remove item at index 0 from cart
    Then the cart should be empty

  Scenario: Continue shopping from cart page
    When I add product at index 0 to cart
    And I click on the shopping cart
    And I click continue shopping
    Then I should be on the product page

  Scenario: Cart persists multiple items
    When I add product at index 0 to cart
    And I add product at index 1 to cart
    And I click on the shopping cart
    Then the cart should contain 2 items
