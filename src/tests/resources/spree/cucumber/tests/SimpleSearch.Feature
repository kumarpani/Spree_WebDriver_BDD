Feature:
  As a shopper I want to search for a product from home page across All Departments

   Scenario: Search for a Product and verify the result and result count
    Given I am on HomePage
    When I search for product "rails"
    Then I should see product with name "rails" in the results with the count of "7"


  Scenario Outline: Search for multiple products and verify the results
    Given I am on HomePage
    When I search for product "<item>"
    Then I should see product with name "<item>" in the results with the count of "<count>"

  Examples:
    | item  | count |
    | rails | 7     |
    | tote  | 2     |