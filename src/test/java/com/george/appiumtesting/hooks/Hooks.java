package com.george.appiumtesting.hooks;

import com.george.appiumtesting.config.ConfigurationManager;
import com.george.appiumtesting.config.TestConfig;
import com.george.appiumtesting.context.PageObjectManager;
import com.george.appiumtesting.context.TestContext;
import com.george.appiumtesting.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("Starting scenario: {}", scenario.getName());
        try {
            TestConfig config = TestConfig.fromSystemProperties();
            DriverManager.initializeDriver(config);
            AppiumDriver driver = DriverManager.getDriver();

            testContext.setDriver(driver);
            testContext.setPageObjectManager(new PageObjectManager(driver));
            testContext.setConfigurationManager(ConfigurationManager.getInstance());
        } catch (Exception e) {
            throw new RuntimeException("Scenario failed", e);
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (DriverManager.hasDriver()) {
                if (scenario.isFailed()) {
                    takeScreenshotOnFailure(scenario);
                }
                DriverManager.quitDriver();
            } else {
                logger.debug("No driver to cleanup for scenario: {}", scenario.getName());
            }
        } catch (Exception e) {
            logger.error("Error during driver cleanup for scenario: {}", scenario.getName(), e);
        }
    }

    private void takeScreenshotOnFailure(Scenario scenario) {
        try {
            byte[] screenshot = DriverManager.getDriver().getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot on failure");
            logger.info("Screenshot attached for failed scenario: {}", scenario.getName());
        } catch (Exception e) {
            logger.warn("Failed to take screenshot for scenario: {}", scenario.getName(), e);
        }
    }
}