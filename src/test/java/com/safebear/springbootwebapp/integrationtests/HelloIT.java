package com.safebear.springbootwebapp.integrationtests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by CCA_Student on 28/02/2018.
 */
public class HelloIT {

    @Test
    public void firstHelloTest(){
        RestAssured.port=8090;
        RestAssured.registerParser("text/plain", Parser.TEXT);
        get("/hello").then().assertThat().body( containsString("Hello"));
    }
}
