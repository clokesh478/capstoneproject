Feature: Alert Handling Functionality

  Scenario: Verify alert message after entering text
    Given User is on the Practice page for alert handling
    When User enters "lokesh" in the alert text field
    And User clicks the alert button
    Then An alert should display the message "Hello lokesh, share this practice page and share your knowledge"
