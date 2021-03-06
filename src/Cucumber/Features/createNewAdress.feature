Feature:Create a new shipment address after login

  Scenario Outline:add next shipment address
    Given User is logged in to CodersLab shop and have created first address
    When  User click on the addresses button
    And   User click on the create new address link
    And   User enter the <alias>, <firstName>, <lastName>, <address>, <city>, <zip>, <phone>, <country>, data
    And   User saves the informations
    Then  User will have new address tile create with correct <alias>, <firstName>, <lastName>, <address>, <city>, <zip>, <phone>, <country>, data

    Examples:
      | alias | firstName | lastName    | address     | city     | zip    | phone     | country         |
      | Dom   | Tomasz    | Tomaszewski | Michalowska | Bajuty   | 04-515 | 555555555 | United Kingdom  |
      | Praca | Adam      | Adamowski   | Tomaszewska | Lubomiry | 02-713 | 909090909 | United Kingdom |