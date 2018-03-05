package com.safebear.springbootwebapp.automationtests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * TestRunner for the Cucumber selenium tests. Set the following in here:
 * 1. The tests that will and won't run (tags)
 * 2. The glue for the StepDefs
 * 3. The features to run
 * 4. Any plugins (e.g. reporting)
 *
 * @author simon stratton
 * @version 1.0
 * @since 05/03/18
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "~@to-do",
        glue = "com.safebear.springbootwebapp.automationtests",
        features = {"classpath:hello.features/hello.feature", "classpath:calculator.features/add.feature"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class RunCukesTestIT {
}
