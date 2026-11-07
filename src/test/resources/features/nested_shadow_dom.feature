Feature: Handling shadow dom elements including nested iframe

  @shadow
  Scenario: Verify that user is able to submit form
    Given User is on Form page
    When User enters the below details in form
    |name|rahul|
    |email|test123@test.com|
    And User clicks on Submit button
    Then User should see the success message
