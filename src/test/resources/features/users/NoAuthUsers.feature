Feature: No Auth Users tests

  @regression @smoke
  Scenario: Get all Users
    When The user calls the Get All Users request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Get single User
    When The user calls the Get Single User request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Delete single User
    When The user calls the Delete Single User request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Sort Users
    Given The user sorts the Users by "price" value and "asc" order
    When The user calls the Sort Users request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Search User
    Given The user filters the User by "address.city" value and "Phoenix" city
    When The user calls the Search Single User request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Create single User
    Given The user generates a User request body
    When The user calls the Create Single User
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Update single User
    Given The user generates a User request body
    When The user calls the Update Single User request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Partial Update single User
    Given The user generates a Partial User request body
    When The user calls the Partial Update Single User request with 2 id
    Then The user verifies that the status code matches 401