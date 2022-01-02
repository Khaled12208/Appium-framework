package com.appiumframwrok;

import com.appiumframwrok.helpers.Helpers;
import com.appiumframwrok.helpers.PropFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.*;


import java.io.IOException;


import java.net.URL;

public class TestBase {

    protected AppiumDriverLocalService server;
    protected AppiumDriver driver;
    private DesiredCapabilities cap;
    private URL url;
    protected PropFile prop = new PropFile("config.properties");
    private SessionId driverSessionID;
    private Helpers helpers = new Helpers();

    @BeforeSuite(alwaysRun = true)
    public void startAppiumServer() {
        server = AppiumDriverLocalService.buildDefaultService();
        server.start();
        helpers.log().info("Appium server started on:  " + server.getUrl().toString());
        try {
            url = new URL(server.getUrl().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @BeforeClass(alwaysRun = true)
    public void startAppiumDriverSession() {

        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("config.platformName"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("config.platformVersion"));
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("config.deviceName"));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("config.automationName"));
        cap.setCapability(MobileCapabilityType.UDID, prop.getProperty("config.udid"));
        cap.setCapability("avd", prop.getProperty("config.avd"));
        cap.setCapability("newCommandTimeout", prop.getProperty("config.newCommandTimeout"));
        cap.setCapability("orientation", prop.getProperty("config.orientation"));
        cap.setCapability("avdLaunchTimeout", prop.getProperty("config.avdLaunchTimeout"));
        cap.setCapability("avdReadyTimeout", prop.getProperty("config.avdReadyTimeout"));
        cap.setCapability("avdArgs", prop.getProperty("config.avdArgs"));
        if (prop.getProperty("config.firstTime.app").trim().contains("true")) {
            cap.setCapability(MobileCapabilityType.APP, helpers.getURL(prop.getProperty("config.appLocation")));
        }
        cap.setCapability("appPackage", prop.getProperty("config.appPackage"));
        cap.setCapability("appActivity", prop.getProperty("config.appActivity"));
        cap.setCapability("appWaitDuration", "30000");
        this.driver = new AndroidDriver(url, cap);
        driverSessionID = driver.getSessionId();
        helpers.log().info("Driver session has been created successfully with capabilities " + cap);
        helpers.log().info("Driver session ID is : " + driverSessionID);

    }

    @AfterClass(alwaysRun = true)
    public void closeAppiumDriver() {
        //Kill Appium Driver
        driver.quit();
        helpers.log().info("Appium driver session " + driverSessionID + " has been closed");

    }


    @AfterSuite(alwaysRun = true)
    public void closeAppiumServer() throws IOException {
        // Kill appium server
        server.stop();
        helpers.log().info("Appium Server Has been killed");
        // if we are using avd, then kill the session
        if (cap.getCapability("avd") != null) {
            String cmdstr = "adb -s emulator-5554 emu kill";
            Runtime.getRuntime().exec(cmdstr);
            helpers.log().info("ADB emulator has been killed");

        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }


}
