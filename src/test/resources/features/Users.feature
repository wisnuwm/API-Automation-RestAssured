Feature: Users endpoint

  #get list users
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be contain page <page>
    And Validate get list user json schema
    Examples:
      |page|
      |1   |
      |2   |
  Scenario Outline: Get list users with exceed page
    Given Get list users with exceed page <page>
    When Send request get list users
    Then Status code should be 404 Not Found
    Examples:
      |page|
      |10   |
      |20   |
  Scenario Outline: Get list users with invalid parameter page
    Given Get list users with invalid parameter page "<page>"
    When Send request get list users
    Then Status code should be 400 Bad Request
    Examples:
      |page|
      |@@@!&*|
      |xyzzzz|

  #Get single user
  Scenario Outline: Get single user with valid parameter id
    Given Get single users with valid parameter id <id>
    When Send request get single users
    Then Status code should be 200 OK
    And Response body page should be contain id <id>
    And Validate get single user json schema
    Examples:
      |id|
      |1   |
      |2   |
      |3   |
      |4   |
  Scenario Outline: Get single user with not found user id
    Given Get single users with not found user id <id>
    When Send request get single users
    Then Status code should be 404 Not Found
    Examples:
      |id|
      |10000   |
      |20000   |
  Scenario Outline: Get single users with invalid parameter id
    Given Get single users with invalid parameter id "<id>"
    When Send request get single users
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |@@@!&*|
      |xyzzzz|

  #Post create new user
  Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name should be "Wisnu Munawar" and job is "QA Engineer"
  Scenario: Post create new user with invalid json file
    Given Create new user with invalid json
    When Send request post create user
    Then Status code should be 400 Bad Request
  Scenario: Post create new user with not completed json property
    Given Create new user with not completed json
    When Send request post create user
    Then Status code should be 400 Bad Request

  #Put update user
  Scenario Outline: Put update user with valid json and valid parameter id
    Given Update user with valid json and parameter id <id>
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name should be "Wisnu Munawar" and job is "QA Engineer"
    Examples:
      |id|
      |1 |
      |2 |
      |3 |
  Scenario Outline: Put update user with valid json and not found user id
    Given Update user with valid json and not found parameter user id <id>
    When Send request put update user
    Then Status code should be 404 Not Found
    Examples:
      |id|
      |10000 |
      |20000 |
  Scenario Outline: Put update user with invalid json and valid parameter id
    Given Update user with invalid json and valid parameter id <id>
    When Send request put update user
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |
      |3 |
  Scenario Outline: Put update user with valid json and invalid parameter id
    Given Update user with valid json and invalid parameter id "<id>"
    When Send request put update user
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |@@@!&*|
      |xyzzzz|
  Scenario Outline: Put update user with invalid json and invalid parameter id
    Given Update user with invalid json and invalid parameter id "<id>"
    When Send request put update user
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |@@@!&*|
      |xyzzzz|

  #Delete user
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      |id|
      |1 |
      |2 |
  Scenario Outline: Delete user with invalid parameter id
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |@@@!&*|
      |xyzzzz|
  Scenario Outline: Delete user with not found user id
    Given Delete user with not found user id <id>
    When Send request delete user
    Then Status code should be 404 Not Found
    Examples:
      |id|
      |10000 |
      |20000 |