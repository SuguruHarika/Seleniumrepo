Feature: Adding the Laptop product to the cart in tutorialNinja online shopping Web application
  Scenario: user should able to search for required product in tutorialNinja and able to add to the cart
    Given user navigates to the tutorialNinja
    When user enter the page should able to login page with valid credential
    And user enter the email as "harika.selenium1@gmail.com" and password as "harika0803" into the fields
    And clicks on the login button
    Then search for the required product
    And user added to the cart
