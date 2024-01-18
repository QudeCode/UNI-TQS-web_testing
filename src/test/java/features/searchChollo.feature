Feature: Search Chollo

Scenario Outline: Search Chollo

Given the user is in the index page
#And the user accepts the cookies
When the user enters <product> on the search bar
And the user press enter
Then a list of <product> or related are shown

Examples:
  | product |
  | laptop  |
  | nintendo|

