Feature: Add product to the shopping bag

  Scenario: User adds product to the shopping bag
    Given User is on the homepage of the ecommerce site
    When User clicks the shop now button
    And User clicks on the product image
    And User selects the color
    And User selects size XS
    And User clicks the add to bag button
    Then The product should be added to the shopping bag
