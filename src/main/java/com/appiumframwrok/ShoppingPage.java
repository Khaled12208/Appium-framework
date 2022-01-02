package com.appiumframwrok;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage extends PageBase {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup")
    private MobileElement header;

    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement passwordTxtFld;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private MobileElement loginButton;

    public ShoppingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
