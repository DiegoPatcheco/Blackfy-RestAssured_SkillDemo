Feature: No Auth Posts tests

  @regression @smoke
  Scenario: Get all Posts
    When The user calls the Get All Posts request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Get single Post
    When The user calls the Get Single Post request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Delete single Post
    When The user calls the Delete Single Post request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Sort Posts
    Given The user sorts the Posts by "price" value and "asc" order
    When The user calls the Sort Posts request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Search Post
    Given The user search the Post that contains "kitchen"
    When The user calls the Search Single Post request
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Create single Post
    Given The user generates a Post request body
    When The user calls the Create Single Post
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Update single Post
    Given The user generates a Post request body
    When The user calls the Update Single Post request with 2 id
    Then The user verifies that the status code matches 401

  @regression @smoke
  Scenario: Partial Update single Post
    Given The user generates a Partial Post request body
    When The user calls the Partial Update Single Post request with 2 id
    Then The user verifies that the status code matches 401