Feature: Home Page Verification

  Background: User is already logged in and on the homepage
    Given User is logged into the application
    And User navigates to "https://www.letskodeit.com/mycourses"

  Scenario: Verify the title of the homepage
    Then The title of the page should be "My Courses"

  Scenario: Verify all homepage sections are displayed
    Then Home section should be displayed
    Then All Courses section should be displayed
    Then Interview section should be displayed
    Then Support section should be displayed
    Then Blog section should be displayed
