Feature: Test Contact functionality

  @Demo
  Scenario Outline: Verify sending message functionality
    Given User opens chrome browser and navigates to the url
    Then Home page should be loaded
    And Contact tab should be displayed at the nav bar
    When User clicks on the Contact tab
    Then New message form should be loaded
    When User enters "<email>" in the Contact Email field
    And enters "<name>" in the Contact Name field
    And enters "<message>" in the Message field
    And clicks on Send message button
    Then Confirmation alert for message should be displayed
    Examples:
      | email         | name | message             |
      | test@test.com | abcd | Message for testing |