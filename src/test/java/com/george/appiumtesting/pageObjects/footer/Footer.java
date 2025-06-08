package com.george.appiumtesting.pageObjects.footer;

import com.george.appiumtesting.pageObjects.common.Validation;
import io.appium.java_client.AppiumDriver;

public class Footer {

    private final FooterLocators footerLocators;
    private final Validation validation;

    public Footer(AppiumDriver driver) {
        this.footerLocators = new FooterLocators(driver);
        this.validation = new Validation(driver);
    }

    //due to proper missing locators this cannot work
    public void footerIsVisible() {
//        this.validation.isVisible(this.footerLocators.copyrightText);
//        this.validation.isVisible(this.footerLocators.termsAndPrivacyLink);
    }

    //due to proper missing locators this cannot work
    public void footerExists() {
//        this.validation.exists(this.footerLocators.copyrightText());
//        this.validation.exists(this.footerLocators.termsAndPrivacyLink());
    }


}
