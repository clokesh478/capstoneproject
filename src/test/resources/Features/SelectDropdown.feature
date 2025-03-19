Feature: Automate functionality for dropdown selection

  Scenario: Verify dropdown selection
    Given User navigates to "https://www.letskodeit.com/practice" for dropdown selection
    When User selects "Honda" from the dropdown
    Then The selected dropdown value should be "Honda"
