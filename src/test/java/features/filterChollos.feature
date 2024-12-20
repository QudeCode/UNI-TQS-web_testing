Feature: Filter Chollos

  Scenario Outline: Views
    Given the user is in the index page
    And the user accepts the cookies
    When the user clicks the filter option
    And selects <view> view
    Then the products should be shown as <view>

  Examples:
    | view |
    | text |
    | list |

  Scenario: Hide Sold Out Products
    Given the user is in the index page
    And the user accepts the cookies
    When the user clicks the filter option
    And the user applies the filter to hide sold-out products
    Then sold-out products should not be displayed
