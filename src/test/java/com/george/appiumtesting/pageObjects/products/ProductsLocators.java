package com.george.appiumtesting.pageObjects.products;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsLocators {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    public WebElement productsTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView")
    public WebElement toggleViewButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement modalSelectorButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[1]")
    public WebElement firstAddToCartButton;

    public ProductsLocators(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}