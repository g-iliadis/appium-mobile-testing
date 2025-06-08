package com.george.appiumtesting.context;

import com.george.appiumtesting.config.ConfigurationManager;
import io.appium.java_client.AppiumDriver;

public class TestContext {

    private ConfigurationManager configurationManager;
    private AppiumDriver driver;
    private PageObjectManager pageObjectManager;

    public TestContext() {

    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public void setPageObjectManager(PageObjectManager manager) {
        this.pageObjectManager = manager;
    }

    public void setConfigurationManager(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }
}