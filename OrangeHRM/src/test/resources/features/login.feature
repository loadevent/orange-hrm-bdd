Feature: Login Functionality for Open Source HRM

  As a user
  I want to be able to log in with my account
  So that I can apply for vacation leave

  Background:
    Given I am on the login page

    Scenario: Successful login with valid credentials
      Given I have entered valid username and valid password
      When I click on the login button
      Then I should be logged in successfully

      Scenario Outline: Unsuccessful login with invalid or empty credentials
        Given I have entered invalid "<username>" and "<password>"
        When I click on the login button
        Then I should see an error message indicating "<error_msg>"

        Examples:
          |  username | password        | error_msg           |
          | admin11   | admin1          | Invalid credentials |
          | admin00   | pass.123        | Invalid credentials |
          | admin11   | admin1          | Invalid credentials |

    Scenario: Navigating to the forgot password page
      When I click on the "Forgot Password" link
      Then I should be redirected to the password reset page