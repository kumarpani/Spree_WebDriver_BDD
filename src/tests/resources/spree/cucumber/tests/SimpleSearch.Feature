Feature:
  As a shopper I want to search for a product from home page across All Departments

  Scenario: Search for a Product and verify the result and result count
    Given I am on HomePage
    When I search for "rails"
    Then I should see "7" of "rails" in the results







