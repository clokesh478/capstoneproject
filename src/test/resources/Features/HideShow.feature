Feature: Hide and Show Element Functionality

  Scenario: Verify the hide and show functionality with text input
    Given I am on the Practice page
    When I hide the element
    Then The element should not be visible
    When I show the element
    Then The element should be visible
    When I enter text "lokesh" in the displayed textbox
    Then I should see the entered text as "lokesh"
