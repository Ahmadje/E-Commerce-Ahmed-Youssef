Feature: F04_Search | users will be able to search for products with different parameters


 Scenario Outline: user could search using product name
    Given user click on search bar
    When user search for product like <product>
    And user click on search Button
    Then user could search successfully and go to search page

   Examples:
     | product |
     | Nokia |
     | book |
     | laptop |
     | nike |


  Scenario: user search using SKU
    Given user click on search bar
    When user search for product like "AP_MBP_13"
    And user click on search Button
    Then user could search successfully with SKU


  Scenario: user search using invalid product name
    Given user click on search bar
    When user search for product like "N@kkk$a"
    And user click on search Button
    Then user could not search