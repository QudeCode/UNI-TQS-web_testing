Feature: Edit Profile
  Scenario Outline: Cancel Change Description
    Given the user is in the index page
    And the user accepts the cookies
    And the user logs in
    When the user navigates to the profile edit page
    And the user changes the description to <New Description>
    And the user press cancel
    Then the profile shouldn't be updated
    Examples:
      | New Description     |
      | Test description 1  |

  Scenario Outline: Change Description
    Given the user is in the index page
    #And the user accepts the cookies
    And the user logs in
    When the user navigates to the profile edit page
    And the user changes the description to <New Description>
    And the user saves the changes
    Then the profile should be updated with <New Description>

    Examples:
    | New Description     |
    | Test description 1  |
    | Test description 2  |
    | Test description 3  |

