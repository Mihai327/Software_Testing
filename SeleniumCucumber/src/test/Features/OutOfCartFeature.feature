Feature: Check the deletion of the products in the cart

  Scenario: Remove an product from cart
    Given I go to the Women's wear - Women clothing page
    Then I add an product to my cart
    And I delete the recent added product
    When I check if the cart is empty