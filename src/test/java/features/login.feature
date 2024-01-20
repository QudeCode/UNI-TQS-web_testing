Feature: Login
  Scenario Outline: Failure Login
    Given the user is in the index page
    #And the user accepts the cookies
    When the user clicks the login option
    And the user enters <bad_username> and <password>
    And the user clicks the submit button
    Then an error appears

    Examples:
      | bad_username          | password      |
      | prueba_fail           | prueba_fail   |

  Scenario Outline: Success Login
    Given the user is in the index page
    #And the user accepts the cookies
    When the user clicks the login option
    And the user enters <username> and <password>
    And the user clicks the submit button
    Then session starts with the username <username>

    Examples:
      | username          | password      |
      | tqs_testing       | testing_123321|


#mail.for.testing.123321@gmail.com