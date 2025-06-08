package com.george.appiumtesting.context;

import io.appium.java_client.AppiumDriver;
import java.util.HashMap;
import java.util.Map;

public class PageObjectManager {

    private final AppiumDriver driver;
    private final Map<Class<?>, Object> pageCache = new HashMap<>();

    public PageObjectManager(AppiumDriver driver) {
        this.driver = driver;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPage(Class<T> pageClass) {
        return (T) pageCache.computeIfAbsent(pageClass, this::createPage);
    }

    private <T> T createPage(Class<T> pageClass) {
        try {
            return pageClass.getConstructor(AppiumDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate page: " + pageClass.getSimpleName(), e);
        }
    }
}