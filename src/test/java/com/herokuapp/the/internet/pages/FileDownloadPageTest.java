package com.herokuapp.the.internet.pages;

import com.herokuapp.the.internet.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static com.herokuapp.the.internet.util.Constants.DOWNLOAD_PATH;

public class FileDownloadPageTest extends BaseTest {
    WebDriver driver;
    FileDownloadPage fileDownloadPage;
    HomePage homePage;


    @BeforeMethod
    public void moveToFileDownloadPage() {
        driver = DriverInit.getInstance().getDriver();
        homePage = new HomePage(driver);
        fileDownloadPage = homePage.clickOnFileDownloadLink();
    }

    @Test
    public void isFileDownloaded() {
        fileDownloadPage.clickOnFile();
        File filesInDownloadFolder = new File(DOWNLOAD_PATH);
        for (File file : filesInDownloadFolder.listFiles()) {
            System.out.println(file.getName());
        }
        Assert.assertTrue(filesInDownloadFolder.listFiles().length > 0);
    }

}