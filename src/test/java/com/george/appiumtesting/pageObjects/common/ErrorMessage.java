package com.george.appiumtesting.pageObjects.common;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public enum ErrorMessage {
    USERNAME_REQUIRED   ("Username is required"),
    PASSWORD_REQUIRED   ("Password is required"),
    INVALID_CREDENTIALS ("Username and password do not match any user in this service.");

    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    /** Only android locator, i could use accessibilityId but does not exist FYI */
    public By locator() {
        return AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']");
    }
    public String text() {
        return text;
    }
}