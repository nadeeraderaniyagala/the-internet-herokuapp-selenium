package com.herokuapp.the.internet.pages;

import com.herokuapp.the.internet.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FramesPageTest extends BaseTest{
    private WebDriver driver;
    HomePage homePage;
    FramesPage framesPage;


    @BeforeMethod
    public void moveToFileDownloadPage() {
        driver = DriverInit.getInstance().getDriver();
        homePage = new HomePage(driver);
        framesPage = homePage.clickOnFramesLink();
    }
    @Test
    public void validateIframe(){
        framesPage.clickOnIframeLink();
        assertEquals(framesPage.getIframeHeaderText(),"An iFrame containing the TinyMCE WYSIWYG Editor");
    }

    @Test()
    public void validateSwitchingToDefaultContent(){
        validateIframe();
//        driver.switchTo().defaultContent();
        driver.navigate().back();
        assertTrue(framesPage.isIframeLinkVisible());

    }

}