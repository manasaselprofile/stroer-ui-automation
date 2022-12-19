Feature: Verify the price and quantity in cart page of amazon

  Scenario: Validating Search hats for men in the search page
    Given User should launch chrome browser
    When User should go to url "https://www.amazon.com"
    And User should give "hats for men" in search box
    And User should click on search
    And User should select the first item in the result
    And User should select the quantity as 2
    And User should select the add to cart
    And User should select go to the cart
    And User should see price and quantity
    And User should reduce the quantity to "1"
    And User should verify the modified quantity as "1"
    Then User should verify the price
    And close browser