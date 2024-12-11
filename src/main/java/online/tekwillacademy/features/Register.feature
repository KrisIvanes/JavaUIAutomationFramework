Feature: The Register Flow test suite

  @run
  Scenario: The system redirects the user  to Account page after successful registration
    #Given The "https://tekwillacademy-opencart.online/" is accessed
    Given The "/" endpoint is accessed
    And Register Page is accessed from Home Page button
    And the register form is populated with data
    #And the privacy toggle bar is enabled
    #When the continueButton is clicked
    And the "privacyToggleBar" from "RegisterPage" is clicked
    When the "continueBtn" from "RegisterPage" is clicked
    Then the URL contains the following keyword "success"

  @run
  Scenario: The system keeps the user on Register page when registering without accepting the privacy rules
    #Given The "https://tekwillacademy-opencart.online/" is accessed
    Given The "/" endpoint is accessed
    And Register Page is accessed from Home Page button
    And the register form is populated with data
 #   And the privacy toggle bar is enabled
    #When the continueButton is clicked
    When the "continueBtn" from "RegisterPage" is clicked
    Then the URL contains the following keyword "register"

  @run
  Scenario Outline: Error message is displayed when registering within invalid <errorFieldName> length
    #Given The "https://tekwillacademy-opencart.online/" is accessed
    Given The "/" endpoint is accessed
    And Register Page is accessed from Home Page button
    And the register form is populated as following:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | RANDOM      |
      | password  | <password>  |
    And a thread sleep of 5 seconds is executed
    #When the continueButton is clicked
    When the "continueBtn" from "RegisterPage" is clicked
    Then the following list of error messages is displayed:
      | <errorFieldName> must be between <min> and <max> characters! |
      |Warning: You must agree to the Privacy Policy!                |
    Examples:
      | firstName | lastName                                       | password                             | errorFieldName | min | max |
      | Random    | Bizgan                                         | 321                                  | Password       | 4   | 20  |
      | Random    | Bizgan                                         | 123456789012345678956356563563563563 | Password       | 4   | 20  |
      | Random    | 1234567890123456789012312345678901234567890123 | 12345678901234567890                 | Last Name      | 1   | 32  |