package com.herokuapp.the.internet.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Log4j2
public class HomePage {
    private WebDriver  driver;

    @FindBy(xpath = "//a[@href='/download']")
    private WebElement fileDownload;

    @FindBy(xpath = "//a[@href='/windows']")
    private WebElement windows;

    @FindBy(xpath = "//a[@href='/frames']")
    private WebElement framesLink;


    public HomePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }


    public FileDownloadPage clickOnFileDownloadLink(){
        fileDownload.click();
        log.info("clickOnFileDownloadLink");
        return new FileDownloadPage(driver);
    }

    public WindowsPage clickOnWindowsLink(){
        windows.click();
        log.info("clickOnWindowsLink");
        return new WindowsPage(driver);
    }

    public FramesPage clickOnFramesLink(){
        framesLink.click();
        log.info("clickOnFramesLink");
        return new FramesPage(driver);
    }

    public List<WebElement> getAllLinks(){
        return driver.findElements(By.tagName("a"));
    }


}
