Feature: Login

Scenario Outline: Login

Given the user is in the index page
And the user accepts the cookies
When the user clicks the login option
And the user enters <username> and <password>
And the user clicks the submit button
Then session starts

Examples:
  | username          | password      |
  | tqs_testing       | testing_123321|