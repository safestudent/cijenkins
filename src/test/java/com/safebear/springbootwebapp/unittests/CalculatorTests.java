package com.safebear.springbootwebapp.unittests;

import com.safebear.springbootwebapp.functions.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Very basic unit tests for the calculator class.
 * Ideally we'd also be using Spring Boot's testing frameworks and mocks also.
 * @author simon stratton
 * @version 1.0
 * @since 05/03/18
 */
public class CalculatorTests {

    // initialise a calculator object
    private Calculator calculator = new Calculator();

    /**
     * When you choose two numbers
     * Then the result returned is the addition of the two numbers
     */
    @Test
    public void testAddition(){
        calculator.setNum1("2");
        calculator.setNum2("3");
        assertEquals(calculator.getResult(),"5");
    }

}
