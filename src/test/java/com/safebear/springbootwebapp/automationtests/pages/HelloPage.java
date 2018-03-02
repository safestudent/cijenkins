package com.safebear.springbootwebapp.automationtests.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by CCA_Student on 01/03/2018.
 */
public class HelloPage {

    WebDriver driver;

    public HelloPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkForTextOnPage(String text){
        return driver.getPageSource().contains(text);
    }

}
