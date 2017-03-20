Feature:
  As a User
  I should be able to Login to the application


  Scenario: As a User I should be able to navigate to the Login Page on clicking the Login Link
    Given I launch the app
    When I login with user name "fd" and password "password"
    Then Home page should be loaded
