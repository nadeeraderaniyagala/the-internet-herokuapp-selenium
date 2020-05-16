package com.herokuapp.the.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class HomePage {
    WebDriver  driver;

    @FindBy(xpath = "//a[@href='/download']")
    private WebElement fileDownload;

    public HomePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }


    public FileDownloadPage clickOnFileDownloadLink(){
        fileDownload.click();
        System.out.println("clickOnFileDownloadLink");
        return new FileDownloadPage(driver);
    }


    public List<WebElement> getAllLinks(){
        return driver.findElements(By.tagName("a"));
    }


}
