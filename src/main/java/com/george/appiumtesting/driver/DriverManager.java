package com.george.appiumtesting.driver;

import com.george.appiumtesting.config.TestConfig;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    private static final ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {

    }

    public static void initializeDriver(TestConfig config) {
        if (driverThreadLocal.get() != null) {
            quitDriver();
        }
        AppiumDriver driver = DriverFactory.createDriver(config);
        driverThreadLocal.set(driver);
    }

    public static AppiumDriver getDriver() {
        AppiumDriver driver = driverThreadLocal.get();
        if (driver == null) {
            throw new IllegalStateException("No Driver initialized:" + Thread.currentThread().getName());
        }
        return driver;
    }

    public static void quitDriver() {
        AppiumDriver driver = driverThreadLocal.get();
        if (driver != null) {
            try {
                logger.info("Quitting Appium {}", Thread.currentThread().getName());
                driver.quit();
            } catch (Exception e) {
                logger.error("Failed to quit driver {}", Thread.currentThread().getName(), e);
            } finally {
                driverThreadLocal.remove();
            }
        } else {
            logger.debug("No driver to quit {}", Thread.currentThread().getName());
        }
    }

    public static boolean hasDriver() {
        return driverThreadLocal.get() != null;
    }
}

