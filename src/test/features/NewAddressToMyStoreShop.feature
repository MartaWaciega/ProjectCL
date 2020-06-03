Feature: Create new address after login

  Scenario Outline: User create new address
    Given User is logged in to the shop
    When User goes to NewAddressPage
    And User enter <alias>, <address>, <city>, <postCode>, <country>, <phone> on your account page
    Then User check field

    Examples:
      | alias | address   | city       | postCode | country        | phone        |
      | Arya  | Zamkowa 3 e| Winterfell | 99-999   | United Kingdom | +66661661661 |