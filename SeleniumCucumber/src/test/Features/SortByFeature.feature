Feature: Check Sort by field functionality

  Scenario: Sort a product by name from A to Z
    Given I go to the Men's wear - Accessories page
    When I check the Sort By name (A-Z option)
    Then I get the sorting result
