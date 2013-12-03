Feature:
  As a shopper I want to search for a product in the catalogue so that I can buy it

  Scenario: Search for a Product
    Given I am on HomePage
    When I search for "tote"
    Then I should see product with name "tote" in the results
