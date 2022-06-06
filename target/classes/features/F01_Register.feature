Feature: F01_Register | user should able to create new account


  Scenario: user register with valid data
    Given user navigate to register page
    And user choose male or female
    When user enter first name
    And user enter last name
    And user enter Date of Birth
    And user enter email
    And user enter company name
    And user enter password
    Then user press on register button
    And user could register successfully