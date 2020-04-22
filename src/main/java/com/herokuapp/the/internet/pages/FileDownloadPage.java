package com.herokuapp.the.internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage {
    WebDriver driver;

    @FindBy(linkText = "some-file.txt")
    WebElement file;

    public FileDownloadPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFile(){
        file.click();
    }
}
