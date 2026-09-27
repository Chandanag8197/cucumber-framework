Feature: Place product order

  @CheckOut
  Scenario: Product added from home page appears in checkout
    Given the shopper is on the store home page
    When the shopper adds "Cauliflower" to the cart
    And the shopper opens checkout
    Then checkout should display "Cauliflower" with quantity 1




