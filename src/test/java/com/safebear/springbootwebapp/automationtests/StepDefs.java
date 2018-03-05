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
 * The StepDefs class for our cucumber selenium tests.
 *
 * @author simon stratton
 * @version 1.0
 * @since 05/03/18
 */
public class StepDefs {

    // Global variable for storing our WebDriver
    private WebDriver driver;
    // Debug variable so we can slow down the tests if we want to see what's happening
    private int debug = 2000; // milliseconds

    // Global variables for our Web Page Objects
    private HelloPage helloPage;
    private AddPage addPage;

    // Getting the port number from the mvn command
    private String PORT = System.getProperty("port");

    // getting the package name
    private String PACKAGE = System.getProperty("pkg");

    // Getting the baseURL from the mvn command
    private String URL = System.getProperty("url");

    /**
     * Initialising our driver for a particular browser and initialising our Page Objects
     */
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        helloPage = new HelloPage(driver);
        addPage = new AddPage(driver);
    }

    /**
     * Close the browsers after the tests are complete
     */
    @After
    public void tearDown(){
        driver.quit();
    }

    @When("^we navigate to the (.+) page$")
    public void we_navigate_to_the_page(String page)  {

        // empty url variable
        String url;

        // updating the url value from the mvn properties
        if (PACKAGE != null){
            // case if the code has been deployed
            url = URL + ":" + PORT + "/" + PACKAGE + "/" + page;
        } else {
            // case if running locally
            url = URL + ":" + PORT + "/" + page;
        }

        driver.get(url);
        try {
            Thread.sleep(debug);
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
