Feature: Test Sauce Demo

  @valid-login
  Scenario: login using valid email and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

  @invalid-login
  Scenario: login using invalid email and password
    Given user is on login page
    And user input username with "locked_out_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user able to see error message "Epic sadface: Sorry, this user has been locked out."

  @problem-login
  Scenario: login using valid email and password
    Given user is on login page
    And user input username with "problem_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage see error catalog

  @Visual-login
  Scenario: login using valid email and password
    Given user is on login page
    And user input username with "visual_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage see error one picture catalog








