@modules
Feature: User spesific modules

Background:
  Given the user is on the login page

  Scenario Outline: Users see user spesific modules
    When the user enter "<userType>" credentials
    Then the user sees "<modules>"

    Examples:
      | userType  | modules                   |
      | student   | Books - Borrowing Books   |
      | librarian | Dashboard - Users - Books |