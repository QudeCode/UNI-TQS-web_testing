Feature: Save Chollos

  Scenario Outline: Save Chollo
    When the user enters <product> on the search bar
    And the user press enter
    And the user clicks on the save button
    And the user goes to their saved deals

    Examples:
      | product |
      | nintendo|

  Scenario: See saved chollo


  Scenario: Unsave chollo
