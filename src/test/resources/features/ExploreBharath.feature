Feature: Validate

  Scenario: Verify user

    Given user opens the application
    Then verify user is on the home page
    When user clicks on the Explore Bharat tab
    Then verify user is on the explore Bharat page
    When user select "activity.input" activity from the india unveiled
    Then verify user is on the activity detail page
    And print the details of the activity
