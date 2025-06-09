#!/bin/bash
set -e
echo "Starting Appium server on port ${APPIUM_PORT}..."
appium --port ${APPIUM_PORT} >appium.log 2>&1 &
APPIUM_PID=$!
echo "Appium PID: $APPIUM_PID"
echo "Waiting for device..."
adb wait-for-device
adb shell input keyevent 82
echo "Setting up APK path..."
APK_PATH="$GITHUB_WORKSPACE/mobile_apps/${APP_ENV}.apk"
echo "DEBUG: APK_PATH resolved to: $APK_PATH"
echo "DEBUG: APP_ENV is: $APP_ENV"
echo "DEBUG: GITHUB_WORKSPACE is: $GITHUB_WORKSPACE"
echo "Checking if APK exists..."
if [ ! -f "$APK_PATH" ]; then
    echo "::error::Expected $APK_PATH but it doesn't exist."
    echo "Contents of mobile_apps directory:"
    ls -la "$GITHUB_WORKSPACE/mobile_apps/" || echo "mobile_apps directory not found"
    kill $APPIUM_PID
    exit 1
fi

echo "Installing APK..."
adb install -r "$APK_PATH"
echo "Running Maven tests..."
mvn -B clean verify \
    -Ddevice=android.emulator \
    -Denv=${APP_ENV} \
    --no-transfer-progress || TEST_EXIT_CODE=$?
echo "Cleaning up Appium process..."
kill $APPIUM_PID || true
echo "Test completed with exit code: ${TEST_EXIT_CODE:-0}"
exit ${TEST_EXIT_CODE:-0}