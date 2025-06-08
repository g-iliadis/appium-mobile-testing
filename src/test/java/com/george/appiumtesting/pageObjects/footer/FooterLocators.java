package com.george.appiumtesting.pageObjects.footer;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FooterLocators {

    //just to show the logic
    //missing accessibility ids in order to create the proper footer locators.
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '2025 Sauce Labs. All Rights Reserved')]")
    public WebElement copyrightText;

    public By copyrightText() {
        return AppiumBy.xpath("//android.widget.TextView[contains(@text, '2025 Sauce Labs. All Rights Reserved')]");
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Terms of Service | Privacy Policy')]")
    public WebElement termsAndPrivacyLink;

    public By termsAndPrivacyLink() {
        return AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Terms of Service | Privacy Policy')]");
    }

    //accessibility ids are missing in order to continue FYI - temporary solution

    public FooterLocators(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}