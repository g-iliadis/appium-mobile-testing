package com.george.appiumtesting.steps;

import io.cucumber.java.en.Given;

public class CommonSteps {

    public CommonSteps() {

    }

    @Given("The application loads properly")
    public void applicationLoads() {
        System.out.println("✅ App loaded");
    }
}
