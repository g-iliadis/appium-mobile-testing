package com.george.appiumtesting.driver;

import com.george.appiumtesting.config.TestConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

  public static AppiumDriver createDriver(TestConfig config) {
     try {
          DesiredCapabilities capabilities = CapabilityBuilder.create(config);
          URL serverUrl = URI.create(config.serverUri).toURL();
          return createPlatformSpecificDriver(config.platform, serverUrl, capabilities);

      } catch (MalformedURLException e) {
          String errorMsg = "Invalid Appium server" + config.serverUri;
          logger.error(errorMsg, e);
          throw new DriverCreationException(errorMsg, e);
      } catch (Exception e) {
          String errorMsg = "Failed to create driver" + config.platform;
          logger.error(errorMsg, e);
          throw new DriverCreationException(errorMsg, e);
      }
    }

    private static AppiumDriver createPlatformSpecificDriver(Platform platform, URL serverUrl, DesiredCapabilities capabilities) {
        return switch (platform) {
            case ANDROID -> new AndroidDriver(serverUrl, capabilities);
            case IOS -> new IOSDriver(serverUrl, capabilities);
        };
    }

    public static class DriverCreationException extends RuntimeException {
        public DriverCreationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
