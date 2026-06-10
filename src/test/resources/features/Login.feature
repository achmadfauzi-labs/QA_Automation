Feature: Login functionality for Sauce Demo application

  Scenario: Successful login with valid credentials
    Given I am on the Sauce Demo login page
    When I enter valid "standard_user" and "secret_sauce"
    And I click the login button
    Then I should be redirected to the product page "https://www.saucedemo.com/inventory.html"

  Scenario: Failed login with invalid username
    Given I am on the Sauce Demo login page
    When I enter valid "user_salah" and "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
    And I should still be on the login page

  Scenario: Failed login with invalid password
    Given I am on the Sauce Demo login page
    When I enter valid "standard_user" and "secret_salah"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
    And I should still be on the login page

  Scenario: Failed login with empty credentials
    Given I am on the Sauce Demo login page
    When I enter valid "" and ""
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"

  Scenario: Failed login with empty username
    Given I am on the Sauce Demo login page
    When I enter valid "" and "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"

  Scenario: Failed login with empty password
    Given I am on the Sauce Demo login page
    When I enter valid "standard_user" and ""
    And I click the login button
    Then I should see an error message "Epic sadface: Password is required"

  Scenario: Login with locked out user
    Given I am on the Sauce Demo login page
    When I enter valid "locked_out_user" and "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Sorry, this user has been locked out."
    And I should still be on the login page

  Scenario Outline: Login validation with multiple data sets
    Given I am on the Sauce Demo login page
    When I enter valid "<username>" and "<password>"
    And I click the login button
    Then I should see an error message "<errorMessage>"

    Examples:
      | username       | password     | errorMessage                                                                 |
      | user_salah     | secret_sauce | Epic sadface: Username and password do not match any user in this service    |
      | standard_user  | secret_salah | Epic sadface: Username and password do not match any user in this service    |
      |                |              | Epic sadface: Username is required                                           |
      |                | secret_sauce | Epic sadface: Username is required                                           |
      | standard_user  |              | Epic sadface: Password is required                                           |
