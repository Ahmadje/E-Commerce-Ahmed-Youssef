Feature: F02_Login | user should be able to login to the system


  Scenario: user login with valid data
    When user navigate to login page
    And user enter "Ahmed_Youssef@live.com" and "P@ssw0rd"
    Then user click on login button
    And user could login successfully and go to home page

  Scenario: user login with invalid data
    When user navigate to login page
    And user enter "Ahmed_Udacity@mail.com" and "WrongP@ssw0rd"
    Then user click on login button
    And user could not login successfully and go to home page