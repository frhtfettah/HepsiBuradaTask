Feature: Before Sale Function on Pet Shop Category

Scenario Outline: User checks if the shopping cart page works correctly when an item from pet shop category is added
#Pre-Condition
  Given User is on the HepsiBurada main page via "<browser>"
  And User is logged in to the system
#Test Steps
  When User clicks Pet Shop from the category menu on the left side
  And User selects a product from Pet Shop page and adds it to the cart
  And User navigates to the Shopping Cart page and checks the page
#Expected
  Then Shopping Cart page should be displayed without any problems
  And Product should be added to the cart without any problems
  And Other necessary buttons and fields that user checked are displayed correctly
  Examples:
    | browser |
    | chrome |
    | edge |