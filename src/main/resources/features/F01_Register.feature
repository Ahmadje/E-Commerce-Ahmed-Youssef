Feature: user should be able to login to the system

#1 Test Scenario:
  Scenario: user login with valid data
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