package com.appiumframwrok;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement usernameTxtFld;

    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement passwordTxtFld;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private MobileElement loginButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterUserName(String userName) {

        writeTxtElement(usernameTxtFld, userName);

    }

    public void enterPassword(String userPassword) {
        writeTxtElement(passwordTxtFld, userPassword);

    }

    public void clickLogin() {
        clickElement(loginButton);
    }

}
