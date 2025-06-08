package com.george.appiumtesting.steps;

import com.george.appiumtesting.config.ConfigurationManager;
import com.george.appiumtesting.context.TestContext;
import com.george.appiumtesting.pageObjects.login.Login;
import io.cucumber.java.en.When;

public class LoginSteps {

    Login login;
    ConfigurationManager config;

    public LoginSteps(TestContext testContext) {
        this.login = testContext.getPageObjectManager().getPage(Login.class);
        this.config = testContext.getConfigurationManager();
    }

    @When("user performs login with {string} credentials")
    public void userPerformsLoginWithCredentials(String user) {
        String username = config.getEnvValue(user + ".username");
        String password = config.getEnvValue(user + ".password");
        login.performLogin(username, password);
    }

}