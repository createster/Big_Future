@modules
Feature: User modules

Background:
  Given the user is on the login page
@stu
    Scenario: student module options
      When user login as a "student"
      Then student see the following <modules>
        | Books           |
        | Borrowing Books |
@lib
  Scenario: librarian module options
    When user login as a "librarian"
    Then librarian see the following <modules>
      | Dashboard |
      | Users     |
      | Books     |