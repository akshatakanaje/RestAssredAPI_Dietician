@UserLogin
Feature: UserLogin Controller

  @Login_validScenarios
  Scenario Outline: valid Credentials
    Given "User" creates request with "<Body>"
    When "User" call "POST" Request with "userLogin"
    Then User receives 200 Status with response body

    Examples:
      | Body                         |
      | Login with valid credentials |

  @Login_InvalidScenarios
  Scenario Outline: Negative test case for user login module
    Given "User" creates request with "<Body>"
    When User call HTTPs method
    Then User receives status

    Examples:
      | Body                         |
      | Login with invalid email id  |
      | Login with invalid password  |
      | Login with invalid endpoints |
      | Login with Invalid methods   |
      | Login with NULL body         |