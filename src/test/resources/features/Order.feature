Feature: Verify products order features

  Background:
    Given User is on login page
    When User enters valid Username and Password
    And User clicks on Login button
    Then User is successfully landed on home screen page

  Scenario: Verify user is able to order product successfully
    Given User is on product page
    When User clicks on Add to Cart button
    Then Add to Cart button changed to Remove button
    And Product count is showing 1 on add to cart icon
    When User clicks on Add to cart icon button
    Then User is able to see the correct product in Add to cart page
    When User clicks on checkout button
    Then User is landed on Checkout Info page
    And User enters the below details
    |first_name|rahul|
    |last_name|saxena|
    |zip_code|110089|
    And User clicks on continue button
    Then User is landed on Checkout Overview page
    Then User verifies the correct product is showing on checkout overview page
    And User clicks on Finish button
    Then User is successfully placed the order and success message is displaying on the screen

  Scenario: Verify user is able to add product successfully
    Given User is on product page
    When User clicks on Add to Cart button
    Then Add to Cart button changed to Remove button

