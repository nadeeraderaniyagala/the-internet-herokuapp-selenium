package com.herokuapp.the.internet.pages;

import com.herokuapp.the.internet.DriverInit;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Log4j2
public class BaseTest {
    private WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void initialization() {
        DriverInit.getInstance().initiateBrowser();
        driver = DriverInit.getInstance().getDriver();
        homePage = new HomePage(driver);
        log.info("Driver initialization successful");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
