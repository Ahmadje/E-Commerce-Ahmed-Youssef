
Feature: user should be able to login to the system

#1 Test Scenario:
  Scenario: user login with valid data
    When user navigate to login page
    And user enter "Ahmed_Youssef@Live.com" and "P@ssw0rd"
    Then user click on login button
    And user could login successfully and go to home page

