Feature: Login

  Scenario Outline: The user forgot the password
    Given the user is in the index page
    And the user accepts the cookies
    When the user clicks the login option
    And the user clicks on Forgot Password
    And the user enters <email> for password recovery
    And the user clicks the Recover Password button
    Examples:
      | email                             |
      | mail.for.testing.123321@gmail.com |

  Scenario Outline: Login
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



