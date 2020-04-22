package com.herokuapp.the.internet;

import com.herokuapp.the.internet.pages.FileDownloadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.MINUTES);
        driver.get("https://the-internet.herokuapp.com/download");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
