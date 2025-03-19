Feature: Automate functionality for auto suggest feature

  Scenario: Verify auto suggest feature
    Given User navigates to "https://www.letskodeit.com/practice" for auto suggest
    When User types "cuc" in the auto suggest box
    Then The suggestion "cucumber" should be displayed
