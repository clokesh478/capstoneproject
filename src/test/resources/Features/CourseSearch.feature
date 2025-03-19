Feature: Course Search Functionality

  Scenario: Verify course search for Python
    Given User is on the Courses page for searching
    When User enters "Python" in the search field
    And User clicks on the search button
    Then Search result for Selenium WebDriver 4 With Python should be displayed
