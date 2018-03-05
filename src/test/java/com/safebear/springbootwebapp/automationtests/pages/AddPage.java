package com.safebear.springbootwebapp.automationtests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * This class defines:
 * 1. how to find all the Web Elements on the /add page
 * 2. all of the actions that can be performed on those elements
 * 3. all of the checks that we need to make on a page. Methods that check the page will return a boolean.
 *
 * @author simon stratton
 * @version 1.0
 * @since 05/03/18
 *
 */
public class AddPage {

    // store our webdriver to interact with the page
    private WebDriver driver;

    // find all the input fields - not the best way to do this, should be using IDs!
    @FindAll({
            @FindBy(tagName = "input")
    })
    private List<WebElement> inputFields;

    /**
     * Constructor that passes through the webdriver and initializes all the page objects
     * @param driver - our webdriver for interacting with the page
     */
    public AddPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * method to enter a number into the first field on the page
     * @param num1 - our first number
     */
    public void enterNumber1(int num1){
        inputFields.get(0).sendKeys(Integer.toString(num1));
    }

    /**
     * method to enter a number into the second field on the page
     * @param num2 - our second number
     */
    public void enterNumber2(int num2){
        inputFields.get(1).sendKeys(Integer.toString(num2));
    }

    /**
     * method to submit the form after numbers have been entered
     */
    public void submitForm(){
        inputFields.get(0).submit();
    }

    /**
     * Method to check the result of submitting two numbers into the form.
     * @param result - the expected result of adding the two numbers together
     * @return boolean - True if the expected result matches the result displayed on screen
     */
    public boolean checkResult(int result){
        return driver.getPageSource().contains(Integer.toString(result));

    }


}
