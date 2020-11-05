@userFunctions
Feature: Add User

  Scenario: Librarian should be able to add, close, and edit user info
    Given the user login as a "librarian"
    When the user navigates to "Users"
    Then the user should be able to add a new user
    And the user should be able to edit and close