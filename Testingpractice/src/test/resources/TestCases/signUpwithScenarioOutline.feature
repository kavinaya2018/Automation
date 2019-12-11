Feature: Sign Up with Exmaples

  Scenario Outline: Succesful account creation with valid user name and password
    Given user launches the browser
    And opens the application
    When click on signin button
    Given user enters email id and clicks on create button <emailData>
    When user enters the required details
    And clicks on submit button
    Then account should be created
    And verify the result
    Then Close the browser 

    Examples: 
      | emailData                 | First Name |
      | oiisdf25@gmail.com  | Testuser   |
      | osifi2336@gmail.com  | Testuser   |
