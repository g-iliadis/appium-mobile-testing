package com.george.appiumtesting.pageObjects.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Validation {

    private final WebDriverWait wait;
    private final WebDriverWait shortWait;
    private final AppiumDriver driver;

    public Validation(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void isVisible(WebElement element) {
        try {
            shortWait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed(), "Element should be visible");
        } catch (TimeoutException e) {
            Assert.fail("Element not visible after wait", e);
        }
    }

    public void isClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Assert.assertTrue(element.isEnabled(), "Element should be clickable");
        } catch (TimeoutException e) {
            Assert.fail("Element not clickable after wait", e);
        }
    }

    public void hasText(WebElement element, String expectedText) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String actualText = element.getText();
            Assert.assertEquals(actualText, expectedText, "Element should contain text '" + expectedText + "' but found '" + actualText + "'");
        } catch (TimeoutException e) {
            Assert.fail("Element not visible to check text", e);
        }
    }

    public void isErrorVisible(ErrorMessage error) {
        WebElement el = wait.until(driver -> driver.findElement(error.locator()));
        Assert.assertTrue(el.isDisplayed(), "Error ‟" + error.text() + "” should be visible");
    }

    public void exists(By locator) {
        try {
            shortWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            Assert.assertTrue(true, "Element should exist in DOM");
        } catch (TimeoutException e) {
            Assert.fail("Element does not exist in DOM after wait", e);
        }
    }

}