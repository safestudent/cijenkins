package com.safebear.springbootwebapp.unittests;

import com.safebear.springbootwebapp.functions.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by CCA_Student on 05/03/2018.
 */
public class CalculatorTests {

    private Calculator calculator = new Calculator();

    @Test
    public void testAddition(){
        calculator.setNum1("2");
        calculator.setNum2("3");
        assertEquals(calculator.getResult(),"5");
    }

}
