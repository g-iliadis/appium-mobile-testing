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

    public boolean allItemsVisible() {
        return menuLocators.allItems.isDisplayed() &&
                menuLocators.webview.isDisplayed() &&
                menuLocators.qrCodeScanner.isDisplayed() &&
                menuLocators.geoLocation.isDisplayed() &&
                menuLocators.drawing.isDisplayed() &&
                menuLocators.about.isDisplayed() &&
                menuLocators.logout.isDisplayed() &&
                menuLocators.resetAppState.isDisplayed();
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
}
