Feature: Checkout Cart process

  Scenario: User completes checkout and sees Thank You message 
    Given User is on homepage for checkout  
    When User navigates to the cart
    And User clicks the checkout button
    And User clicks the final checkout button
    Then The "Thank You!" message should be displayed
