package com.safebear.springbootwebapp.automationtests.pages;

import org.openqa.selenium.WebDriver;

/**
 * This class defines:
 * 1. how to find all the Web Elements on the /hello page
 * 2. all of the actions that can be performed on those elements
 * 3. all of the checks that we need to make on a page. Methods that check the page will return a boolean.
 *
 * @author simon stratton
 * @version 1.0
 * @since 05/03/18
 *
 */
public class HelloPage {

    // store the webdriver when it's passed through
    private WebDriver driver;

    /** constructor to capture the webdriver when this class is initialised
     *
     * @param driver - the webdriver for whatever browser we're using.
     */
    public HelloPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Simple method to check that Hello World is in the page source as there's no elements on screen
     * @param text - the expected text
     * @return boolean - True if the text is on screen.
     */
    public boolean checkForTextOnPage(String text){
        return driver.getPageSource().contains(text);
    }

}
