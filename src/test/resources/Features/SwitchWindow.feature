Feature: Automate functionality for switching windows

  Scenario: Verify switching to a new window
    Given User navigates to "https://www.letskodeit.com/practice" for switch window
    When User clicks on the switch window button
    Then The new window URL should be "https://www.letskodeit.com/courses"
