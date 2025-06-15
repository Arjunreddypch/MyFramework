@tag1
Feature: Login and add item to shopping cart
	@tag2
  Scenario Outline: Successful login and adding a product to the cart
    
    Given the user logs in with username "<username>" and password "<password>"
    When the user selects the "<product>" from search results
    Then the shopping cart should contain "<product>"

    Examples:
      | username   | password  | product       |
      | nagarjuna.pc9@gmail.com      | Arjun789   | Zara Coat      |







