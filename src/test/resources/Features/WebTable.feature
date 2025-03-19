Feature: Web Table Price Validation

  Scenario: Verify the price of Python Programming Language
    Given User is on the Practice page for web table
    When User checks the price of "Python Programming Language"
    Then The price should be "30"
