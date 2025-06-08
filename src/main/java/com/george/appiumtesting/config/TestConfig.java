package com.george.appiumtesting.config;

import com.george.appiumtesting.driver.Platform;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;

public final class TestConfig {

    public final Platform platform;
    public final String deviceName;
    public final String udid;
    public final String port;
    public final Path appPath;
    public final String serverUri;

    private TestConfig(Builder b) {
        platform = b.platform;
        deviceName = b.deviceName;
        udid = b.udid;
        port = b.port;
        appPath = b.appPath;
        serverUri = b.serverUri;
    }

    public static TestConfig fromSystemProperties() {
        ConfigurationManager c = ConfigurationManager.getInstance(); // snapshot once
        return builder()
                .platform(Platform.fromString(c.getDeviceValue("platform")))
                .deviceName(c.getDeviceValue("deviceName"))
                .udid(c.getDeviceValue("udid"))
                .port(c.getDeviceValue("port"))
                .appPath(c.getAppPath())
                .serverUri(c.getDeviceValue("appiumServerUrl"))
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Platform platform;
        private String deviceName;
        private String udid;
        private String port;
        private Path appPath;
        private String serverUri;

        public Builder platform(Platform p) {
            this.platform = p;
            return this;
        }

        public Builder deviceName(String n) {
            this.deviceName = n;
            return this;
        }

        public Builder udid(String id) {
            this.udid = id;
            return this;
        }

        public Builder port(String p) {
            this.port = p;
            return this;
        }

        public Builder appPath(String p) {
            this.appPath = Paths.get(p);
            return this;
        }

        public Builder serverUri(String u) {
            this.serverUri = u;
            return this;
        }

        public TestConfig build() {
            requireNonNull(platform, "platform");
            requireNonNull(deviceName, "deviceName");
            requireNonNull(udid, "udid");
            requireNonNull(port, "port");
            requireNonNull(appPath, "appPath");
            requireNonNull(serverUri, "serverUri");
            return new TestConfig(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof TestConfig tc) && asKey().equals(tc.asKey());
    }

    @Override
    public int hashCode() {
        return asKey().hashCode();
    }

    @Override
    public String toString() {
        return asKey();
    }

    private String asKey() {
        return platform + "|" + deviceName + "|" + udid + "|" + port + "|" + appPath + "|" + serverUri;
    }
}