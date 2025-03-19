Feature: Course Category Filtering

  Scenario: Verify category selection
    Given User is on the Courses page for filtering
    When User selects category "Software Development" from the dropdown
    Then The selected category should be "Software Development"
