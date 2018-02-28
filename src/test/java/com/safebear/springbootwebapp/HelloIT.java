package com.safebear.springbootwebapp;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by CCA_Student on 28/02/2018.
 */
public class HelloIT {

    @Test
    public void firstHelloTest(){
        get("/hello").then().assertThat().body("message", equalTo("Hello"));
    }
}
