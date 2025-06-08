package com.george.appiumtesting.pageObjects.login;

import com.george.appiumtesting.pageObjects.common.ErrorMessage;
import com.george.appiumtesting.pageObjects.common.Validation;
import io.appium.java_client.AppiumDriver;

public class Login {

    private final LoginLocators locators;
    private final Validation validations;

    public Login(AppiumDriver driver) {
        this.locators = new LoginLocators(driver);
        this.validations = new Validation(driver);
    }

    public void performLogin(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.clickLoginButton();
    }

    public void enterUsername(String username) {
        locators.usernameField.clear();
        locators.usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        locators.passwordField.clear();
        locators.passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        locators.loginButton.click();
    }

    public void loginPageLoaded() {
        this.validations.isVisible(locators.usernameField);
        this.validations.isVisible(locators.passwordField);
        this.validations.isVisible(locators.loginButton);
    }

    public void loginRelatedErrors(String error) {
        ErrorMessage expectedError = switch (error.toLowerCase()) {
            case "invalid credentials" -> ErrorMessage.INVALID_CREDENTIALS;
            case "missing password" -> ErrorMessage.PASSWORD_REQUIRED;
            case "missing username" -> ErrorMessage.USERNAME_REQUIRED;
            default -> throw new AssertionError("Unknown error type:");
        };
        this.validations.isErrorVisible(expectedError);
    }
}
