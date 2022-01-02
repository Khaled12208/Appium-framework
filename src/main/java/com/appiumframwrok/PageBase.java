package com.appiumframwrok;

import com.appiumframwrok.helpers.Helpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Coordinates;

public class PageBase {

    protected Helpers help = new Helpers();

    public AppiumDriver driver;

    // Constructor to init all web driver and js excutor
    public PageBase(AppiumDriver webDriver) {

        this.driver = webDriver;

    }
    public void clickElement (MobileElement element)
    {
        element.click();
    }

    public void writeTxtElement (MobileElement element, String txt)
    {
        element.sendKeys(txt);
    }

    public boolean isDisplayed(MobileElement element)
    {
        return element.isDisplayed();
    }
    



}
