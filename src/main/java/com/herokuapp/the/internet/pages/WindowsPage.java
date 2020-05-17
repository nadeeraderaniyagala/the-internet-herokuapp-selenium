package com.herokuapp.the.internet.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

@Log4j2
public class WindowsPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/windows/new']")
    private WebElement newWindow;

    @FindBy(xpath = "//body//*[contains(text(),'New Window')]")
    private WebElement newWindowText;


    public WindowsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public Set<String> clickOnNewWindowLink(){
        newWindow.click();
        log.info("clickOnNewWindowLink");
        return  driver.getWindowHandles();
    }


    public boolean isNewWindowTextVisible(){
        return newWindowText.isDisplayed();
    }

    public boolean isNewWindowLinkVisible(){
        return newWindow.isDisplayed();
    }


}
