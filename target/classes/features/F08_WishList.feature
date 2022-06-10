Feature: F08_WishList  |  guest user could add products to wishlist

  Scenario: success message is visible after adding item to wishlist
    When user add item to wishlist
    Then wishlist notification success is visible


  Scenario: number of wishlist items in home page is increased
    When user add item to wishlist
    Then wishlist notification success is visible
    And user get the number of wishlist items after adding item
    Then the number of wishlist increased


  Scenario: added items are displayed on wishlist
    When user add item to wishlist
    Then wishlist notification success is visible
    And user get the number of wishlist items after adding item
    And user go to wishlist page
    Then the number of items greater than zero in wishlist page
