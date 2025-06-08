package com.george.appiumtesting.steps;

import com.george.appiumtesting.config.ConfigurationManager;
import com.george.appiumtesting.context.TestContext;
import com.george.appiumtesting.pageObjects.login.Login;
import io.cucumber.java.en.And;
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

    @When("user performs login without username")
    public void userPerformsLoginMissingUsername() {
        String password = config.getEnvValue( "standard.password");
        login.enterPassword(password);
        login.clickLoginButton();
    }

    @When("user performs login without password")
    public void userPerformsLoginMissingPassword() {
        String username = config.getEnvValue( "standard.username");
        login.enterUsername(username);
        login.clickLoginButton();
    }

    @And("Login page appears")
    public void loginPageLoaded() {
        login.loginPageLoaded();
    }

    //could be in common class helper
    @And("the {string} error appears")
    public void errorAppears(String error) {
        login.loginRelatedErrors(error);
    }

}