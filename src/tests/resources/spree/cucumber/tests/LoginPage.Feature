Feature:
  As a User I should be able to Log into the application

  Scenario: As a User I should be able to navigate to the Login Page on clicking the Login Link
    Given I am on HomePage
    When When I click on the Login Link
    Then User should be navigated to Login Page

  Scenario: As a Registered User I should be able to Login With Valid Credentials
    Given I am on Login Page
    And I Enter Valid Email ID
    And I Enter Valid Password
    When I click on the Login Button
    # yet to parameterize - need to implement cucumber table





