Feature: Validate Duty Free functionalities

  Background:

    Given user opens the application
    Then verify user is on the home page
    When user clicks on the duty free tab
    Then verify user is on the duty free page
    And verify list of airports where displayed
    When user selects the "airport.input" airport
    Then verify airport duty free page is displayed
    When user choose order pickup location "location.input" and confirm age "age.input"
    Then verify products where displayed
    When user selects a particular category "category.input"

  Scenario: Verify user can add a product to the cart

    And selects "product.input" and add the product to the cart
    Then verify cart quantity increased to 1
    When user clicks on cart icon
    Then verify user is on the cart page
    And print the details of the product added to the cart


  Scenario: Verify user can sort products by price low to high

    And sort them "price low to high" based on the price
    Then verify products are sorted by "price low to high"


  Scenario: Verify user can sort products by price high to low

    And sort them "price high to low" based on the price
    Then verify products are sorted by "price high to low"
