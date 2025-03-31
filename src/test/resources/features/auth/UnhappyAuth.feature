Feature: Unhappy Auth tests

  @regression @smoke
  Scenario Outline: Login with wrong credentials
    Given The user gets the <credentialType> credentials Login request body
    When The user calls the Login request
    Then The user verifies that the status code matches <statusCode>
    Examples:
      | credentialType | statusCode |
      | "invalid"      | 400        |
      | "empty"        | 400        |