Feature: User logs in letskodeit

Scenario: Logging in letskodeit
    Given User is on login page
    When User enters "<email>" and "<password>"
    And User clicks on login 
    Then User is on homepage

Examples: 
    | email                  | password  |
    | clokesh@gmail.com      | clok@123  |
