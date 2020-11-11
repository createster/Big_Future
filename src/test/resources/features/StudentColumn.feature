@studentRecords
Feature: students should be able to see tables with default info
Background:
  Given the user is on the login page

  Scenario: Students see tables with default info
    When the user enters student credentials
    Then table should have following column names

      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      | Year        |
      | Borrowed By |