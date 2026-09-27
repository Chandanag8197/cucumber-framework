Feature: Search and place the order for products

  @SearchOrder
  Scenario: Search for product in both Home page and product page
    
    Given User is on GreenCart landing page
    When User searched with "tom" shortname and extracted actual name of product
    Then User searched the same "tom" shortname in offers page 
    And validate product name in offers page matches with actual name of product

