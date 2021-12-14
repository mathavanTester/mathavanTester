#Author: Madhavan.email@your.domain.com
@mobile
Feature: Mobile

  Background: 
    Given user launches flipkart application
    And user login by entering crendentials
@hardcode
  Scenario: Mobile purchase
    When user search mobile
    And user click on the mobile name
    Then user click on add to cart
@onedim @dim
  Scenario: Mobile purchase by using  one dim list
    When user search mobile by one dim list
      | Apple | realme | one plus |
    And user click on the mobile name
    Then user click on add to cart

  Scenario: Mobile purchase by using  one dim map
    When user search mobile by one dim map
      | 1 | Apple    |
      | 2 | realme   |
      | 3 | one plus |
    And user click on the mobile name
    Then user click on add to cart

  Scenario Outline: Mobile purchase by outline
    When user search mobile"<Mobile name>"
    And user click on the mobile name
    Then user click on add to cart

    Examples: 
      | Mobile name |
      | realme      |
      | Apple       |
      | SAMSUNG     |
  