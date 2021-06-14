Feature:Buy product and get confirmation info

  Scenario:Byu product and make a screenshot of transaction
    Given User is logged in to CodersLab shop and is on the home page of the store
    When User search for "Hummingbird Printed Sweater" and enter the product detail
    And pick the chosen size "M" and amount equal "5"
    And add the product to the basket
    And confirm address, delivery method and payment method
    Then take a screenshot of your order