Feature: Mouse Hover Functionality

  Scenario: Verify mouse hover and options visibility
    Given User is on the Practice page for mouse hover
    When User hovers over the mouse hover button
    Then The "Top" option should be displayed
    Then The "Reload" option should be displayed

  Scenario: Verify clicking an option from mouse hover menu
    Given User is on the Practice page for mouse hover
    When User hovers over the mouse hover button
    And User clicks on "Top" option
    Then The page should scroll to the top
