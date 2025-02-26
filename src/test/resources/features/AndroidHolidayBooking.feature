Feature: Validate Holiday Booking Functionalities

  Scenario:

    Given user opens the application
    Then verify user is on the home page
    When user clicks on the holidays tab
    Then holidays page is displayed
    When user enters "destination" and clicks on search button
    Then verify tour packages page is displayed
    When user clicks on from city and enters the "fromCity"
    And user clicks on more filters button and add a theme as "theme"
    And apply filters as sort to "sortOption" and package type as "without flights"
    Then verify list of packages are displayed
    When user selects the package
    Then verify package page is displayed and print the details
    When user customizes the hotels and rooms as "hotelRoomSortOption"
    Then print the price after changing the hotels and rooms
    When user clicks on book now button and fill the details:
      | firstName | lastName | age |
      | Joe       | Root     | 35  |
      | Steve     | Smith    | 34  |

    And clicks continue booking button
    Then verify user is on payment page
