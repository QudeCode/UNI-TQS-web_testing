Feature: Save Chollos

  Scenario Outline: Save Chollo
    Given the user is in the index page
    And the user accepts the cookies
    When the user enters "<product>" on the search bar
    And the user press enter
    And the user clicks on the save button on the first product
    And the user goes to their saved Chollos
    Then the saved chollo should be displayed

    Examples:
      | product |
      | nintendo|

  Scenario: See saved chollo
    Given the user is in the index page
    And the user accepts the cookies
    And the user goes to their saved Chollos
    Then the saved chollo should be displayed

  Scenario: Unsave chollo
    Given the user is in the index page
    And the user accepts the cookies
    And the user goes to their saved Chollos
    When the user unsaves the chollo
    Then the Chollo should be removed from the saved Chollos
