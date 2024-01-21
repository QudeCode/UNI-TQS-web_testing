Feature: Filter Chollos

  Scenario: Change View
    Given the user is in the index page
    #And the user accepts the cookies
    When the user clicks the filter option
    And selects the new vision type
    Then the products should be shown in a different way

  Scenario: Hide Sold Out Products
    Given the user is in the index page
    #And the user accepts the cookies
    When the user applies the filter to hide sold-out products
    Then sold-out products should not be displayed
