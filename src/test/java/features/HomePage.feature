Feature: Home Page activities

  @Demo
  Scenario: Navigate to Home Page
    Given User opens chrome browser and navigates to the url
    Then Home page should be loaded
    And Top nav bar should be visible
