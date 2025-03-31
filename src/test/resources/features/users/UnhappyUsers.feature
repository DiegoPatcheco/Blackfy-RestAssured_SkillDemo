Feature: Unhappy Users tests

  Background: Unhappy Users tests preconditions
    Given The user gets authenticated with the server

  @regression @smoke
  Scenario: Get invalid single User
    When The user calls the Get Single User request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Delete invalid single User
    When The user calls the Delete Single User request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Update invalid single User
    Given The user generates a User request body
    When The user calls the Update Single User request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Partial Update invalid single User
    Given The user generates a Partial User request body
    When The user calls the Partial Update Single User request with 2500 id
    Then The user verifies that the status code matches 404
