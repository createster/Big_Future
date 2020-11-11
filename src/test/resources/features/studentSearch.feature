Feature: students search in different categories

  Background:
    Given the user is on the login page

  @sswdc
  Scenario: students should be able to search in different categories
    When the user enters student credentials
    Then the user should see the books from related category