Feature: Auth tests

  @regression @smoke
  Scenario: Login with valid credentials
    Given The user gets the "valid" credentials Login request body
    When The user calls the Login request
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms
    And The user gets the Login response body
    And The user verifies that the id is positive
    And The user verifies that both Access Token and Refresh Token length matches 360 characters