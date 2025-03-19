Feature: Automate functionality for enabling and disabling fields

  Scenario: Verify disabling the field
    Given User navigates to "https://www.letskodeit.com/practice" for enable-disable field
    When User clicks on disable button
    Then The field should be disabled

  Scenario: Verify enabling the field and entering text
    Given User navigates to "https://www.letskodeit.com/practice" for enable-disable field
    When User clicks on enable button
    Then The field should be enabled
    When User enters "lokesh" in the enabled field
    Then The entered text should be "lokesh"
