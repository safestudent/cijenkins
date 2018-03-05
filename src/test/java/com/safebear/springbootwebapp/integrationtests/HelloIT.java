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
        RestAssured.port=8090;
        RestAssured.registerParser("text/plain", Parser.TEXT);
        get("/hello").then().assertThat().body( containsString("Hello"));
    }

}
