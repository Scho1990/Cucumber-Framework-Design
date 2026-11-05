@product
Feature: Verify products page features

  Background:
    Given User is on login page
    When User enters valid Username and Password
    And User clicks on Login button
    Then User is successfully landed on home screen page

  Scenario: Verify user is able to add the product in cart
    Given User is on product page
    When User clicks on Add to Cart button
    Then Add to Cart button changed to Remove button
    And Product count is showing 1 on add to cart icon
    When User clicks on Add to cart icon button
    Then User is able to see the correct product in Add to cart page