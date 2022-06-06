Feature: F03_ChangeCurrency | user could switch between currencies [$, €]


  Scenario: guest user can choose € currency
    Given user select “Euro” from currency dropdown list
    When user select “Dollar” from currency dropdown list

