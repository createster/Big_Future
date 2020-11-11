@bookRecords
Feature: Librarians should be able see book records

  Background:
    Given the user is on the login page
    Then the user enters librarian credentials

    Scenario: Librarian sees the book records
      When a librarian navigates to book records
      Then the librarian sees the followig options
        | 5   |
        | 10  |
        | 15  |
        | 50  |
        | 100 |
        | 200 |
        | 500 |