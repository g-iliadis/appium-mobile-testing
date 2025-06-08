package com.george.appiumtesting.pageObjects.login;

import io.appium.java_client.AppiumDriver;

public class Login {

    private final LoginLocators locators;

    public Login(AppiumDriver driver) {
        this.locators = new LoginLocators(driver);
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
}
