Feature: wishlist feature

  Scenario: wishlist scenario
    Given I am on the WestwingNow home page
    And I store current wish list item's count in to "CURRENT_WISH_LIST_CNT"
    When I search for "möbel"
    Then I should see product listing page with a list of products
    When I click on wishlist icon of the first found product
    Then I should see the login/registration overlay
    When I switch to login form of the overlay
    And I log in with ""  credentials
    Then the product should be added to the wishlist
    And "CURRENT_WISH_LIST_CNT" should be incremented by 1
    When I go to the wishlist page
    And I delete the product from my wishlist
    Then the product should be removed from the wishlist