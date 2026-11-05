Feature: Login functionalities

  @smoke
  Scenario: Verify user is able to login with valid credentials
    Given User is on login page
    When User enters valid Username and Password
    And User clicks on Login button
    Then User is successfully landed on home screen page