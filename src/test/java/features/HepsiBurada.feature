Feature: Before Sale Function on Pet Shop Category

Scenario: User checks if the shopping cart page works correctly when an item from pet shop category is added
#Pre-Condition
  Given User navigates to the HepsiBurada home page
  And User is logged in to the HepsiBurada web application
#Test Steps
When User clicks Pet Shop from the category menu on the left side
And User selects a product from Pet Shop page and adds it to the cart
And User navigates to the Shopping Cart page
And User checks the necessary buttons and fields
#Expected
Then System should navigate to the Pet Shop category page correctly
And Product should be added to the cart without any problems
And Shopping Cart page should be displayed without any problems
And Necessary buttons and fields that user checked are displayed correcty