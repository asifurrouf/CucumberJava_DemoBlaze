Feature: Test Product functionalities

  @Demo
  Scenario: Verify filtering products by Categories
    Given User opens chrome browser and navigates to the url
    Then Home page should be loaded
    And Categories section should be displayed
    When User clicks on Laptops option
    Then Laptop items should be Displayed

  @Demo
  Scenario: Verify viewing product description
    Given User opens chrome browser and navigates to the url
    Then Home page should be loaded
    When User scrolls down to Products section
    And Clicks on a product from the products list
    Then Product description page should be loaded
    And Product image should be displayed
    And Product name should be displayed
    And Product price should be displayed
    And Add to cart button should be displayed