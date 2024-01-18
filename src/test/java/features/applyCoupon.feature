Feature: Apply Coupon

Scenario: applyCoupon


Given the user is in the index page
And the user accepts the cookies
When the user clicks the menu option
And clicks the codigos de descuento option
And clicks on No button
Then can get a coupon


#And the user enters <username> and <password>
#Examples:
# | username          | password      |
#| tqs_testing       | testing_123321|