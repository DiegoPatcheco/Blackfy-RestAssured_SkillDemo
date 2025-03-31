Feature: Unhappy Posts tests

  Background: Unhappy Posts tests preconditions
    Given The user gets authenticated with the server

  @regression @smoke
  Scenario: Get invalid single Post
    When The user calls the Get Single Post request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Delete invalid single Post
    When The user calls the Delete Single Post request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Update invalid single Post
    Given The user generates a Post request body
    When The user calls the Update Single Post request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Partial Update invalid single Post
    Given The user generates a Partial Post request body
    When The user calls the Partial Update Single Post request with 2500 id
    Then The user verifies that the status code matches 404
