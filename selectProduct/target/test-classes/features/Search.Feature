Feature: Search
  As a end user
  I want to search for a product
  So that i can give respective results

  Scenario: Search for a product
    Given Open FireFox Browser and Navigate to Argos
    
    When I enter the product "nike"
    Then I should see respective product
