package com.herokuapp.the.internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.herokuapp.the.internet.util.Constants.DOWNLOAD_PATH;

public class DriverInit {

    private static DriverInit driverInit;
    private WebDriver driver;

    private DriverInit(){
    }

    public static DriverInit getInstance(){
        if (driverInit ==null){
            driverInit = new DriverInit();
        }
        return driverInit;
    }

    public void initiateBrowser(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver.exe" );
        File downloadFolder = new File(DOWNLOAD_PATH);
        downloadFolder.mkdir();
        Map<String,Object> preferences= new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.default_directory",DOWNLOAD_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",preferences);
        options.addArguments("start-maximized");options.addArguments("enable-automation");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
