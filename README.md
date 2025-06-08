# Mobile Automation Setup

This project uses **Appium**, **TestNG**, and **Java 21** for automated mobile testing on Android devices and emulators.  
We use the **Page Object Pattern** and locate elements via **Accessibility IDs**.

---

## Prerequisites
- **Java 21**
- **Maven 3.9+**
- **Node.js + NPM**
- **Android SDK** with properly set `ANDROID_HOME` variables

---

## Setup

### 1. Install Appium (Android & Windows)

```bash
npm install -g appium

appium driver install uiautomator2
```

### 2. Verify Appium Install

```bash
npm install -g appium-doctor

appium-doctor
```

### 3. Find Accessibility IDs
Download Appium Inspector:
👉 https://github.com/appium/appium-inspector

Start an Appium server:
```bash
appium
```
Open Appium Inspector and connect to your device/emulator.

Open the application under test.

Click on UI elements to review the AccessibilityID.

For the parameters use the following in inspector
```bash
{
"platformName": "Android",
"appium:deviceName": "yhwsonr8beba5pqo",
"appium:udid": "yhwsonr8beba5pqo",
"appium:automationName": "UiAutomator2",
"appium:noReset": false,
"appium:fullReset": false,
"appium:autoGrantPermissions": true,
"appium:appWaitActivity": "*"
}
```

### 4. Implement your tests
Follow BDD and declarative scenarios style
Add your new features to features folder

### 5. Run your tests
You can choose between multiple configs & environments to run your tests.

### 6. Basic Command
```bash
mvn clean verify -Ddevice=android.real -Denv=test
```
With the basic command you can run your test under your real android device.
You must add on [android.real.properties](src/test/resources/device/android.real.properties) deviceName and udid.

### 7. Cucumber Report
After each execution a cucumber report can be found at [overview-features.html](target/cucumber-html-reports/cucumber-html-reports/overview-features.html)

### Farm testing
You can run the same tests under multiple devices (Android , IOS, Real and Emulators).
After connected all preferred devices with your testing server/computer.

You can start two separate appium servers on different ports. Either manually or with a bash script.
One will handle the IOS execution and the other the android.

You should create the necessary configuration files under [device](src/test/resources/device), 
where you will define the emulator or real device parameters.
Next, add your preferred running configuration in [testng.xml](src/test/resources/testng.xml).
Finally, create the appropriate Maven Surefire profile to load the corresponding testng.xml file.

