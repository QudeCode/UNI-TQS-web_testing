Feature: Save Chollos

  Scenario Outline: Save Chollo
    When the user enters "<product>" on the search bar
    And the user press enter
    And the user clicks on the save button
    And the user goes to their saved deals

    Examples:
      | product |
      | nintendo|

  Scenario: See saved chollo
    Given the user is in the index page
    And the user accepts the cookies
    And the user goes to their saved deals
    Then the saved chollo should be displayed

  Scenario: Unsave chollo
    Given the user is in the index page
    And the user accepts the cookies
    And the user goes to their saved deals
    When the user unsaves the chollo
    Then the chollo should be removed from the saved deals
