package com.george.appiumtesting.pageObjects.menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MenuLocators {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ALL ITEMS\")")
    public WebElement allItems;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WEBVIEW\")")
    public WebElement webview;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"QR CODE SCANNER\")")
    public WebElement qrCodeScanner;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"GEO LOCATION\")")
    public WebElement geoLocation;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"DRAWING\")")
    public WebElement drawing;

    @AndroidFindBy(accessibility = "test-ABOUT")
    @iOSXCUITFindBy(accessibility = "test-ABOUT")
    public WebElement about;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LOGOUT\")")
    public WebElement logout;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"RESET APP STATE\")")
    public WebElement resetAppState;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Close']/android.widget.ImageView")
    public WebElement closeButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    public WebElement cartIcon;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView")
    public WebElement menuIcon;

    public MenuLocators(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}