Feature: Test Signup functionality

  @Demo
  Scenario Outline: Signup with valid data
    Given User opens chrome browser and navigates to the url
    Then Signup tab should be displayed at the nav bar
    When User clicks on Signup tab from nav bar
    Then Signup form should be loaded
    And Username input field should be displayed
    And Password input field should be displayed
    When User enters username into the "<Username>" field
    And User enters password into the "<Password>" field
    And Clicks on Sign up button
    Then Confirmation alert should be displayed

    Examples:
      | Username        | Password |
      | Test_User_1234523223 | abcd123  |
