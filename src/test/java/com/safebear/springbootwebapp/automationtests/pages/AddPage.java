package com.safebear.springbootwebapp.automationtests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by CCA_Student on 05/03/2018.
 */
public class AddPage {
    WebDriver driver;


    @FindAll({
            @FindBy(tagName = "input")
    })
    private List<WebElement> inputFields;

    public AddPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterNumber1(int num1){
        inputFields.get(0).sendKeys(Integer.toString(num1));
    }

    public void enterNumber2(int num2){
        inputFields.get(1).sendKeys(Integer.toString(num2));
    }

    public void submitForm(){
        inputFields.get(0).submit();
    }

    public boolean checkResult(int result){
        return driver.getPageSource().contains(Integer.toString(result));

    }


}
