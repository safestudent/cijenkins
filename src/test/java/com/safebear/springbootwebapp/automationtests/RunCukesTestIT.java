package com.safebear.springbootwebapp.automationtests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by CCA_Student on 11/12/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "~@to-do",
        glue = "com.safebear.springbootwebapp.automationtests",
        features = "classpath:hello.features/hello.feature",
        plugin = {"pretty", "html:target/cucumber"}
)
public class RunCukesTestIT {
}
