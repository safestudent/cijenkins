package com.safebear.springbootwebapp.automationtests;

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
    String URL = System.getProperty("url");

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        helloPage = new HelloPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @When("^we navigate to the (.+) page$")
    public void we_navigate_to_the_page(String page) {
        driver.get(URL + "/" + page);
    }

    @Then("^we are greeted with the word (.+)$")
    public void we_are_greeted(String greeting) {
        assertTrue(helloPage.checkForTextOnPage(greeting));
    }
}
