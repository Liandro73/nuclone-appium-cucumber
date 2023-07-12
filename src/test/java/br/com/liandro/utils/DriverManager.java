package br.com.liandro.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverManager {

    public static AppiumDriver driver;
    public static WebDriverWait webDriverWait;
    static String platform;
    protected static int SHORT_TIMEOUT = 5;
    protected static int LONG_TIMEOUT = 30;

    public static String userName;
    public static String accessKey;

    static File app = null;
    static File classpathRoot = new File(System.getProperty("user.dir"));

    public static void startDriver() throws MalformedURLException {

        tearDown();

        platform = System.getProperty("platform").toUpperCase();

        app = new File(classpathRoot, "/src/test/resources/app/nuclone.apk");

        if (platform.equals("ANDROID")) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setUdid("emulator-5554")
                    .setPlatformName("Android")
                    .setPlatformVersion("13.0")
                    .setDeviceName("Emulador Pixel 4")
                    .setApp(app.getAbsolutePath());
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
        } else if (platform.equals("DEVICE_FARM")) {
            userName = System.getProperty("user");
            userName = System.getProperty("key");

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("app", "bs://7eac23bd24deb6822fef3a389b6660ffe16dc106");
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("userName", userName);
            browserstackOptions.put("accessKey", accessKey);
            browserstackOptions.put("osVersion", "13.0");
            browserstackOptions.put("deviceName", "Samsung Galaxy S23");
            browserstackOptions.put("projectName", "Nuclone");
            browserstackOptions.put("buildName", "2.0.0");
            browserstackOptions.put("sessionName", "Show balance");
            browserstackOptions.put("appiumVersion", "2.0.0");
            browserstackOptions.put("local", "false");
            browserstackOptions.put("debug", "true");
            browserstackOptions.put("timezone", "Sao_Paulo");
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_TIMEOUT));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
        } else {
            System.out.println("Platform not found");
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
