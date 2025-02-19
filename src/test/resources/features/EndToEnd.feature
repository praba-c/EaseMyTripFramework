Feature: Validate End To End Functionalities

  Background:

    Given user opens the application
    Then verify user is on the home page
    When user clicks on the holidays tab
    Then holidays page is displayed
    When user enters "destination" and clicks on search button
    Then verify tour packages page is displayed
    When user clicks on from city and enters the "fromCity"
    And user clicks on more filters button and add a theme as "theme"

  Scenario: Verify Holiday Booking scenarios

    And apply filters as sort to "sortOption" and package type as "without flights"
    Then verify list of packages are displayed
    When user select the package with recommended tag
    Then verify packages page is displayed and print the details
    When user clicks on enquiry button and fill the "name" "mobile" and "email"
    And clicks enquiry button
    Then verify query number is generated
    When user clicks on goto homepage btn
    Then verify user is on the home page


  Scenario: Verify Holiday Booking

    And apply filters as sort to "sortOption" and package type as "with flights"
    Then verify list of packages are displayed
    When user selects the package
    Then verify packages page is displayed and print the details
    When user customizes the hotels and rooms as "hotelRoomSortOption"
    Then print the price after changing the hotels and rooms
    When user clicks on enquiry button and fill the "name" "mobile" and "email"
    And clicks enquiry button
    Then verify user is on query page
    And verify query number is generated
    When user clicks on goto homepage btn
    Then verify user is on the home page