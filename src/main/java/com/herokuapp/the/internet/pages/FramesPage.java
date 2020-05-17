package com.herokuapp.the.internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/iframe']")
    private WebElement iframeLink;

    @FindBy(tagName = "h3")
    private WebElement iframeHeader;

    public FramesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnIframeLink(){
        iframeLink.click();
    }

    public boolean isIframeLinkVisible(){
        return iframeLink.isDisplayed();
    }

    public String getIframeHeaderText(){
        return iframeHeader.getText();
    }


}
