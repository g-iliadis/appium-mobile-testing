package com.george.appiumtesting.driver;

import com.george.appiumtesting.config.TestConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class CapabilityBuilder {

    private static final Map<Platform, Map<String, Object>> PLATFORM_CAPABILITIES = new HashMap<>();

    static {

        Map<String, Object> androidCaps = new HashMap<>();
        androidCaps.put("appium:automationName", "UiAutomator2");
        androidCaps.put("appium:systemPort", 8200);
        androidCaps.put("appium:noReset", false);
        androidCaps.put("appium:ignoreHiddenApiPolicyError", true);
        androidCaps.put("appium:appWaitActivity", "*");
        androidCaps.put("appium:appWaitDuration", 30000);
        androidCaps.put("appium:autoGrantPermissions", true);
        PLATFORM_CAPABILITIES.put(Platform.ANDROID, androidCaps);

        Map<String, Object> iosCaps = new HashMap<>();
        iosCaps.put("appium:automationName", "XCUITest");
        iosCaps.put("appium:noReset", false);
        iosCaps.put("appium:autoAcceptAlerts", true);
        iosCaps.put("appium:autoDismissAlerts", false);
        PLATFORM_CAPABILITIES.put(Platform.IOS, iosCaps);
    }

    public static DesiredCapabilities create(TestConfig config) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", config.platform.name());
        capabilities.setCapability("appium:deviceName", config.deviceName);
        capabilities.setCapability("appium:udid", config.udid);
        capabilities.setCapability("appium:app", config.appPath.toAbsolutePath().toString());

        Map<String, Object> platformCaps = PLATFORM_CAPABILITIES.get(config.platform);
        if (platformCaps != null) {
            platformCaps.forEach(capabilities::setCapability);
        }

       if (config.platform == Platform.IOS) {
            capabilities.setCapability("appium:wdaLocalPort",
                    config.port);
        }

        return capabilities;
    }
}