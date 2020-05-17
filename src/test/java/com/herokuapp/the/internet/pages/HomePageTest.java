package com.herokuapp.the.internet.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Log4j2
public class HomePageTest extends BaseTest{


    @Test(enabled = false)
    public void validateAllLinksWorking(){
        List<WebElement> allAnchorTags =homePage.getAllLinks();
        for(WebElement ele : allAnchorTags){
            String href = ele.getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(2000);
                con.connect();
                if(con.getResponseCode() == 200){
                    log.info( "Working Link : "+ href );
                }else{
                    log.info( "Broken Link : "+ href );
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}