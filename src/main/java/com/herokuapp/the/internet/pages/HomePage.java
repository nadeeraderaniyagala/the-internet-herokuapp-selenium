package com.herokuapp.the.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver  driver;

    @FindBy(xpath = "//a[@href='/download']")
    private WebElement fileDownload;

    @FindBy(xpath = "//a[@href='/windows']")
    private WebElement windows;


    public HomePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }


    public FileDownloadPage clickOnFileDownloadLink(){
        fileDownload.click();
        System.out.println("clickOnFileDownloadLink");
        return new FileDownloadPage(driver);
    }

    public WindowsPage clickOnWindowsLink(){
        windows.click();
        System.out.println("clickOnWindowsLink");
        return new WindowsPage(driver);
    }

    public List<WebElement> getAllLinks(){
        return driver.findElements(By.tagName("a"));
    }


}
