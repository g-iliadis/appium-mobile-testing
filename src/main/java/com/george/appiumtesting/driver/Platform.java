package com.george.appiumtesting.driver;

public enum Platform {
    ANDROID,
    IOS;

    public static Platform fromString(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Platform name cannot be null or empty");
        }

        try {
            return valueOf(name.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    String.format("Unsupported platform: '%s'. Use ANDROID or IOS", name)
            );
        }
    }
}