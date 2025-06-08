package com.george.appiumtesting.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class ConfigurationManager {

    private final Properties deviceProps;
    private final Properties envProps;

    private final String device;
    private final String environment;

    private static final ConcurrentMap<String, ConfigurationManager> instances = new ConcurrentHashMap<>();

    private ConfigurationManager(String device, String environment) {
        this.device = device;
        this.environment = environment;
        this.deviceProps = loadProperties("device/" + device + ".properties");
        this.envProps = loadProperties("env/" + environment + ".properties");
    }

    public static ConfigurationManager getInstance() {
        String device = System.getProperty("device", "android.emulator");
        String env = System.getProperty("env", "test");
        String key = device + ":" + env;
        return instances.computeIfAbsent(key, k -> new ConfigurationManager(device, env));
    }

    private Properties loadProperties(String filePath) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new RuntimeException("Could not find config: " + filePath);
            }
            Properties props = new Properties();
            props.load(input);
            return props;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from " + filePath, e);
        }
    }

    public String getDeviceValue(String key) {
        return deviceProps.getProperty(key);
    }

    public String getEnvValue(String key) {
        return envProps.getProperty(key);
    }

    public String getAppPath() {
        String appDir = "mobile_apps/";
        String environment = this.environment;
        String extension = this.device.toLowerCase().contains("ios") ? ".ipa" : ".apk";
        String fileName = environment + extension;
        File appFile = new File(appDir + fileName);
        if (!appFile.exists()) {
            throw new RuntimeException("App file not found: " + appFile.getAbsolutePath());
        }
        return appFile.getAbsolutePath();
    }
}