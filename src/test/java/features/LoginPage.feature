Feature: Test login functionality

  @Demo
  Scenario Outline: Login with valid data
    Given User opens chrome browser and navigates to the url
    Then Login tab should be displayed at the nav bar
    When User clicks on Login tab from nav bar
    Then Login form should be loaded
    And Username input field should be displayed in login form
    And Password input field should be displayed in login form
    When User enters username into the "<Username>" field in login form
    And User enters password into the "<Password>" field in login form
    And Clicks on Log in button
    Then Username should be displayed on the nav bar

    Examples:
      | Username        | Password |
      | Test_User_123452 | abcd123  |