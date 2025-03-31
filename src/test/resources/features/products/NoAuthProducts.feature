Feature: No Auth Products tests

  @regression @smoke
  Scenario: Get all Products
    When The user calls the Get All Products request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Get single Product
    When The user calls the Get Single Product request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Delete single Product
    When The user calls the Delete Single Product request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Sort Products
    Given The user sorts the Products by "price" value and "asc" order
    When The user calls the Sort Products request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Search Product
    Given The user search the Product that contains "kitchen"
    When The user calls the Search Single Product request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Create single Product
    Given The user generates a Product request body
    When The user calls the Create Single Product
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Update single Product
    Given The user generates a Product request body
    When The user calls the Update Single Product request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Partial Update single Product
    Given The user generates a Partial Product request body
    When The user calls the Partial Update Single Product request with 2 id
    Then The user verifies that the status code matches 401