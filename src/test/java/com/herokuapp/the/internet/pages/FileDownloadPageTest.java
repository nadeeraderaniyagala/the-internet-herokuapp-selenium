package com.herokuapp.the.internet.pages;

import com.herokuapp.the.internet.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static com.herokuapp.the.internet.util.Constants.DOWNLOAD_PATH;

public class FileDownloadPageTest {
    WebDriver driver;
    FileDownloadPage fileDownloadPage;

    @BeforeMethod
    public void setUp(){
        DriverInit.getInstance().initiateBrowser();
        driver = DriverInit.getInstance().getDriver();
        fileDownloadPage = new FileDownloadPage(driver);
    }

    @Test
    public void isFileDownloaded(){
        fileDownloadPage.clickOnFile();
        File filesInDownloadFolder= new File(DOWNLOAD_PATH);
       for(File file: filesInDownloadFolder.listFiles() ){
           System.out.println(file.getName());
       }
       Assert.assertTrue(filesInDownloadFolder.listFiles().length>0);

    }

}