package br.com.liandro.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static AppiumDriver<?> driver;
    public static WebDriverWait webDriverWait;
    static DesiredCapabilities capabilities = new DesiredCapabilities();
    static String platform;

    static File app = null;
    static File classpathRoot = new File(System.getProperty("user.dir"));

    public static void startDriver() throws MalformedURLException {

        tearDown();

        platform = System.getProperty("platform").toUpperCase();

        app = new File(classpathRoot, "/src/test/resources/app/nuclone.apk");

        if (platform.equals("ANDROID")) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto G5s");
            capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriverWait = new WebDriverWait(driver, 30);
        } else if (platform.equals("DEVICE_FARM")) {
            capabilities.setCapability("browserstack.user", "dernivalliandro_HC5zlF");
            capabilities.setCapability("browserstack.key", "sNwiuaTaDB2TbfPcVzi1");
            capabilities.setCapability("os_version", "13.0");
            capabilities.setCapability("device", "Google Pixel 7");
            capabilities.setCapability("app", "bs://7eac23bd24deb6822fef3a389b6660ffe16dc106");
            driver = new AppiumDriver<>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriverWait = new WebDriverWait(driver, 30);
        } else {
            System.out.println("Platform not found");
        }
    }

    public static AppiumDriver<?> getDriver() {
        return driver;
    }

    public static void tearDown() {
        if(driver != null) {
            driver.closeApp();
            driver.quit();
        }
    }

}
