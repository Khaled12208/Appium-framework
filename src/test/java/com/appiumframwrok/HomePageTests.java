package com.appiumframwrok;

import com.appiumframwrok.helpers.Helpers;
import com.appiumframwrok.helpers.PropFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomePageTests extends TestBase {


    Helpers helper = new Helpers();
    HomePage homePage;

   @Test
   public void TC01_loginWithValidUserName(){

       homePage = new HomePage(driver);
       homePage.enterUserName("standard_user");
       homePage.enterPassword("secret_sauce");
       homePage.clickLogin();

   }


}
