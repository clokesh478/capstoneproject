Feature: Automate functionality for checkbox selection

  Scenario: Select Honda checkbox
    Given User navigates to "https://www.letskodeit.com/practice" for checkbox   
    When User selects "Honda" from the checkbox options
    Then "Honda" checkbox should be verified
