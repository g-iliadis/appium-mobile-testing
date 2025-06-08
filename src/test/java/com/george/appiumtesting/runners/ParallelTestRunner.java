package com.george.appiumtesting.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/java/com/george/appiumtesting/features",
        glue = {"com.george.appiumtesting.hooks", "com.george.appiumtesting.steps"},
        monochrome = true
)

public class ParallelTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}