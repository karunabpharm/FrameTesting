Feature: Search For Produch Puma
Scenario Outline:Checking Customer Review


    Given I enter the product "puma"
    When I set filer review to "4"
    Then I should see product above  "4"
    Examples:
    ||