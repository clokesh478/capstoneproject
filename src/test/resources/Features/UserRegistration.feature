Feature: Registration in letskodeit

Scenario: Registering in letskodeit
    Given User is on letskodeit homepage
    And User clicks on SIGN IN button
    And User clicks on Sign Up
    When User is required to enter "<FirstName>" and "<LastName>" and "<EmailAddress>" and "<Password>" and "<ConfirmPassword>"
    And User clicks on Im not a robot
    And User clicks on SIGN UP button
    Then User is successfully registered

Examples: 
  | FirstName | LastName | EmailAddress          | Password     | ConfirmPassword  |
  | c         | lokesh   | clokesh@gmail.com     | clok@123     | clok@123         |
