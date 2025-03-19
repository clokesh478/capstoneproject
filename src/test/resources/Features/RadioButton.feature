Feature: Automate functionality for radio button

  Scenario: Select BMW option
    Given User navigates to "https://www.letskodeit.com/practice"    
    When User selects "BMW" from the radio button options
    Then "BMW" should be verified
