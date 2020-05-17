package com.herokuapp.the.internet.pages;

import com.herokuapp.the.internet.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class WindowsPageTest extends BaseTest {
    private WebDriver driver;
    private WindowsPage windowsPage;
    private HomePage homePage;

    @BeforeMethod
    public void moveToFileDownloadPage() {
        driver = DriverInit.getInstance().getDriver();
        homePage = new HomePage(driver);
        windowsPage = homePage.clickOnWindowsLink();
    }

    @Test
    public void validateNewWindow(){
        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = windowsPage.clickOnNewWindowLink();
        for (String childWindow : windowHandles) {
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                assertTrue(windowsPage.isNewWindowTextVisible());
            }
        }
        driver.close();
        driver.switchTo().window(parentWindow);
        assertTrue(windowsPage.isNewWindowLinkVisible());
    }

}