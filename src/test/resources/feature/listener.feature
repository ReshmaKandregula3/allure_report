
@Shopping
@Severity=critical
@Owner=Reshma
@Epic:Shopping-website

Feature: Swaglabs shopping site
  @Regression @Smoke
  Scenario: Verify login page
    Given Username and Password
    Then login to the website

  @Smoke
  Scenario: Verify shopping cart
    Given Add product to the cart
    Then Click on continue

  @Regression
  Scenario: Continue Shopping
    Given Add another item
    Then Checkout the product
    And remove Item from cart

  @Smoke
  Scenario: Finishing order process
    Given Enter address information
    Then Click Finish

  @Regression
  Scenario: Logout from page
    Given goto react button
    Then click logout
#    And Close Browser

