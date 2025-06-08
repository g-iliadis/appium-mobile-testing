package com.george.appiumtesting.steps;

import com.george.appiumtesting.config.ConfigurationManager;
import com.george.appiumtesting.context.TestContext;
import com.george.appiumtesting.pageObjects.products.Products;
import io.cucumber.java.en.Then;

public class ProductSteps {

    Products products;
    ConfigurationManager config;

    public ProductSteps(TestContext testContext) {
        this.products = testContext.getPageObjectManager().getPage(Products.class);
        this.config = testContext.getConfigurationManager();
    }

    @Then("product page appears")
    public void loginPageLoaded() {
        products.productPageLoaded();
    }
}
