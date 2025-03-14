Feature: Validate Activities Functionalities

  Background:

    Given user opens the application
    Then verify user is on the home page
    When user clicks on the activities tab
    Then activities page is displayed
    When user selects the "activity.location"
    Then verify activities related to the location where displayed

  Scenario: Verify Activity Scenarios

    And apply filter "duration.input" and "special.input"
    When user clicks on book now button on a package that contains "keyword"
    Then verify activity details page is displayed
    When user selects the "date", 3 and click on book now button
    Then verify user is on user information page
    When user fills the details:
      | prefix | firstName | lastName |
      | Mr.    | Steve     | Smith    |
      | Mr.    | Dwayne    | Johnson  |
      | Mr.    | Nathan    | Lyon     |
    And other details "mobile.input", "email.input", "panName.input" and "panNumber.input"
    Then print the price details


  Scenario Outline: Verify user can sort activity packages by price
    And sort the suggestions by "<sortOrder>"
    Then verify suggestions are sorted based on "<sortOrder>"

    Examples:
      | sortOrder   |
      | Low to High |
      | High to Low |