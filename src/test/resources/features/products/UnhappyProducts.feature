Feature: Unhappy Products tests

  Background: Unhappy products tests preconditions
    Given The user gets authenticated with the server

  @regression @smoke
  Scenario: Get invalid single Product
    When The user calls the Get Single Product request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Delete invalid single Product
    When The user calls the Delete Single Product request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Update invalid single Product
    Given The user generates a Product request body
    When The user calls the Update Single Product request with 2500 id
    Then The user verifies that the status code matches 404

  @regression @smoke
  Scenario: Partial Update invalid single Product
    Given The user generates a Partial Product request body
    When The user calls the Partial Update Single Product request with 2500 id
    Then The user verifies that the status code matches 404
