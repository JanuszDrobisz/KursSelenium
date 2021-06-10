Feature:Change user information after login

  Scenario:Change user birthday date, gender and signup for a newsletter
    Given User is logged in to CodersLab shop
    When  User goes to UserinformationPage
    And  User changes his birthday to "02/12/1999"
    And User signs up for our newsletter
    And User saves information
    Then User sees "Information successfully updated."