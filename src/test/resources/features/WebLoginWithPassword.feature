@Web
Feature: Validate login with password functionalities

  Scenario: Verify user can login with password

    Given user opens the application
    Then verify user is on the home page
    When user clicks on login button and selects customer login
    Then verify a popup is displayed asking for mobile number or email for login
    Then verify the system ask password for logging in
    When user selects the password option and enters the "password"
    And clicks on login button
    Then verify user is logged in