@Login @Smoke
Feature: User Login

  Background:
    Given The application loads properly
    And Login page appears

  @SWAG-1 @Positive
  Scenario: Successful login with valid credentials
    When user performs login with "valid" credentials
    Then product page appears

  @SWAG-2 @Negative
  Scenario: Unsuccessful login with invalid credentials
    When user performs login with "invalid" credentials
    Then the "invalid credentials" error appears

  @SWAG-3 @Negative
  Scenario: Unsuccessful login with missing password
    When user performs login without password
    Then the "missing password" error appears

  @SWAG-4 @Negative
  Scenario: Unsuccessful login with missing username
    When user performs login without username
    Then the "missing username" error appears
