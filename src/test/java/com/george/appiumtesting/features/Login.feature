@Login @Smoke
Feature: User Login

  Background:
    Given The application loads properly

  @SWAG-1 @Positive
  Scenario: Successful login with valid credentials
    When user performs login with "valid" credentials
