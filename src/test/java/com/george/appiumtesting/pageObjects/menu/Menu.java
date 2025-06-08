package com.george.appiumtesting.pageObjects.menu;

import com.george.appiumtesting.pageObjects.common.Validation;
import io.appium.java_client.AppiumDriver;

public class Menu {

    private final MenuLocators menuLocators;
    private final Validation validations;

    public Menu(AppiumDriver driver) {
        this.menuLocators = new MenuLocators(driver);
        this.validations = new Validation(driver);
    }

    public void tapLogout() {
        menuLocators.logout.click();
    }

    public void closeMenu() {
        menuLocators.closeButton.click();
    }

    public void openMenu() {
        menuLocators.menuIcon.click();
    }

    public void mainMenuItemsAreVisible() {
        this.validations.isVisible(menuLocators.menuIcon);
        this.validations.isVisible(menuLocators.cartIcon);
    }

    public void subMenuItemsAreVisible() {
        this.validations.isVisible(menuLocators.allItems);
        this.validations.isVisible(menuLocators.webview);
        this.validations.isVisible(menuLocators.qrCodeScanner);
        this.validations.isVisible(menuLocators.geoLocation);
        this.validations.isVisible(menuLocators.drawing);
        this.validations.isVisible(menuLocators.about);
        this.validations.isVisible(menuLocators.logout);
        this.validations.isVisible(menuLocators.resetAppState);
    }

}
