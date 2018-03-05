package com.safebear.springbootwebapp.automationtests;

import com.safebear.springbootwebapp.automationtests.pages.AddPage;
import com.safebear.springbootwebapp.automationtests.pages.HelloPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by CCA_Student on 01/03/2018.
 */
public class StepDefs {

    ChromeDriver driver;
    HelloPage helloPage;
    AddPage addPage;
    String URL = System.getProperty("url");

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        helloPage = new HelloPage(driver);
        addPage = new AddPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @When("^we navigate to the (.+) page$")
    public void we_navigate_to_the_page(String page)  {
        driver.get(URL + "/" + page);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^we are greeted with the word (.+)$")
    public void we_are_greeted(String greeting) {
        assertTrue(helloPage.checkForTextOnPage(greeting));
    }

    @When("^we add (\\d+) and (\\d+)$")
    public void we_add_and(int num1, int num2) {
        addPage.enterNumber1(num1);
        addPage.enterNumber2(num2);
        addPage.submitForm();
    }

    @Then("^we have (\\d+)$")
    public void we_have(int result) throws Throwable {
        assertTrue(addPage.checkResult(result));
    }
}
