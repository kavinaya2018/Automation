Feature: HomePage of the applicaiton

  Scenario: Succesful sign in with valid user name and password
    Given user launches the browser
    And opens the application
    When click on signin button
    Then go to email verification page
    And verify the result

  Scenario: UnSuccesful sign in with invalid user name and password
    Given user launches the browser
    And opens the application
    When click on signin button
    Then should not go to email verification page
    And verify the result

  @AccountCreations
  Scenario: Succesful account creation with valid user name and password
    Given user launches the browser
    And opens the application
    When click on signin button
    Given user enters email id and clicks on create button
    When user enters the required details
    And clicks on submit button
    Then account should be created
    And verify the result

  Scenario: UnSuccesful account creation with invalid user name and password
    Given user enters email id and clicks on create button
    When user enters the required details
    Then account should not be created
    And verify the result
