Feature: Automate functionality for switching tabs

  Scenario: Verify switching to a new tab
    Given User navigates to "https://www.letskodeit.com/practice" for switch tab
    When User clicks on the switch tab button
    Then The new tab URL should be "https://www.letskodeit.com/courses"
