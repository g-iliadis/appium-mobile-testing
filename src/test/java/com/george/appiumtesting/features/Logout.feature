@Logout @Smoke @UI
Feature: User Logout

  Background:
    Given The application loads properly
    And Login page appears

  @SWAG-5 @Positive @UI
  Scenario: Successful login with valid credentials
    When user performs login with "valid" credentials
    Then product page appears
    And open the main menu
    Then perform logout
    And Login page appears
