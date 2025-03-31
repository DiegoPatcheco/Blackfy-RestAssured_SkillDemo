Feature: Posts tests

  Background: Posts tests preconditions
    Given The user gets authenticated with the server

  @regression @smoke
  Scenario: Get all Posts
    When The user calls the Get All Posts request
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms

  @regression @smoke
  Scenario: Get single Post
    When The user calls the Get Single Post request with 2 id
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms
    And The user verifies the Post schema response body

  @regression @smoke
  Scenario: Delete single Post
    When The user calls the Delete Single Post request with 2 id
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms

  @regression @smoke
  Scenario: Sort Posts
    Given The user sorts the Posts by "views" value and "desc" order
    When The user calls the Sort Posts request
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms

  @regression @smoke
  Scenario: Search Post
    Given The user search the Post that contains "history"
    When The user calls the Search Single Post request
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms

  @regression @smoke
  Scenario: Create single Post
    Given The user generates a Post request body
    When The user calls the Create Single Post
    Then The user verifies that the status code matches 201
    And The user verifies that the response time is less than 1000 ms

  @regression @smoke
  Scenario: Update single Post
    Given The user generates a Post request body
    When The user calls the Update Single Post request with 2 id
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms

  @regression @smoke
  Scenario: Partial Update single Post
    Given The user generates a Partial Post request body
    When The user calls the Partial Update Single Post request with 2 id
    Then The user verifies that the status code matches 200
    And The user verifies that the response time is less than 1000 ms