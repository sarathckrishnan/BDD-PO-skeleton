Feature:
  As a User
  I should be able to Login to the application


  Scenario: As a User I should be able to login with valid credentials
    Given I launch the app
    When I login with user name "feb9@mailinator.com" and password "password@123"
    Then Home page should be loaded




