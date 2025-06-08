package com.george.appiumtesting.steps;

import com.george.appiumtesting.config.ConfigurationManager;
import com.george.appiumtesting.context.TestContext;
import com.george.appiumtesting.pageObjects.menu.Menu;
import io.cucumber.java.en.And;

public class MenuSteps {

    Menu menu;
    ConfigurationManager config;

    public MenuSteps(TestContext testContext) {
        this.menu = testContext.getPageObjectManager().getPage(Menu.class);
        this.config = testContext.getConfigurationManager();
    }

    @And("open the main menu")
    public void openSubMenuOptions() {
        menu.openMenu();
        menu.subMenuItemsAreVisible();
    }

    @And("perform logout")
    public void performLogout() {
        menu.tapLogout();
    }

}
