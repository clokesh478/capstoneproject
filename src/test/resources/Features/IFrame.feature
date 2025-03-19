Feature: iFrame Handling with Move to Element

  Scenario: Verify switching to and from an iFrame with moveToElement
    Given User is on the Practice page with iframe
    When User moves near the iframe
    And User switches to the iframe
    Then User should be inside the iframe
    When User switches back to the main page
    Then User should be back on the main page
