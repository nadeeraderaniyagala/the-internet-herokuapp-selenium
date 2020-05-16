package com.herokuapp.the.internet.pages;

import com.herokuapp.the.internet.DriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.*;

public class HomePageTest extends BaseTest{

    @Test
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
                    System.out.println( "Working Link : "+ href );
                }else{
                    System.out.println( "Broken Link : "+ href );
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}