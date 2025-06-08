package com.george.appiumtesting.pageObjects.products;

import com.george.appiumtesting.pageObjects.common.Validation;
import com.george.appiumtesting.pageObjects.footer.Footer;
import com.george.appiumtesting.pageObjects.menu.Menu;
import io.appium.java_client.AppiumDriver;

public class Products {

    private final ProductsLocators locators;
    private final Validation validations;
    private final Menu menu;
    private final Footer footer;

    public Products(AppiumDriver driver) {
        this.locators = new ProductsLocators(driver);
        this.validations = new Validation(driver);
        this.menu = new Menu(driver);
        this.footer = new Footer(driver);
    }

    public void productPageLoaded() {
        this.menu.mainMenuItemsAreVisible();
        this.productMenuIsVisible();
        this.productsAreVisible();
        this.footer.footerExists();
    }

    public void productMenuIsVisible() {
        this.validations.isVisible(this.locators.productsTitle);
        this.validations.isVisible(this.locators.toggleViewButton);
        this.validations.isVisible(this.locators.modalSelectorButton);
    }

    public void productsAreVisible() {
        this.validations.isVisible(this.locators.firstAddToCartButton);
    }


}
