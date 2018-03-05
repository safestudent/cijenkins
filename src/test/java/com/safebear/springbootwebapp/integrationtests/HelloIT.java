package com.safebear.springbootwebapp.integrationtests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Integration tests for the website
 *
 * PLEASE NOTE: These should be moved to domain StepDefs and linked to feature files through a different
 * RunCukesTestIT test runner.
 *
 * @author simon stratton
 * @version 1.0
 * @since 05/03/18
 *
 *
 */
public class HelloIT {

    /**
     * Very simple tests to check that the /hello request returns 'Hello' in the body.
     */
    @Test
    public void firstHelloTest(){
        // getting the port from the mvn command and converting it into an integer
        int PORT = Integer.parseInt(System.getProperty("port"));

        // getting the package name
        String PACKAGE = System.getProperty("pkg");

        // setting the port number for the test
        RestAssured.port=PORT;

        // setting the base URL for the test
        RestAssured.baseURI=System.getProperty("url");

        // register parser for the response as plain text
        RestAssured.registerParser("text/plain", Parser.TEXT);

        if (PACKAGE != null) {
            // Send the get request to the /hello url and check what comes back
            // case if it has been deployed
            get("/" + PACKAGE + "/hello")
                    .then()
                    .assertThat()
                    .body(containsString("Hello"));
        } else {
            // Send the get request to the /hello url and check what comes back
            // case if it has been deployed
            get("/hello")
                    .then()
                    .assertThat()
                    .body(containsString("Hello"));
        }
    }

}
