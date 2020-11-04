@login
  Feature: Users should be able to login

    Background:
      Given the user is on the login page


      Scenario Outline: Login with different accounts
        When the user enter "<userType>" credentials
        Then the user on "<page>"
        Examples:
          | userType  | page      |
          | student   | bookspage |
          | librarian | Dashboard |

