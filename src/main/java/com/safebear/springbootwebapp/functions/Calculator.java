package com.safebear.springbootwebapp.functions;

/**
 * The Calculator object contains the parameters captures the parameters from the UI.
 * It also contains the logic performed on those parameters and returns the result.
 *
 * @author Simon Stratton
 * @version 1.0
 * @since 05/03/2018
 *
 */
public class Calculator {

    // The parameter captured from the UI for the /add page
    private String num1;
    private String num2;

    // The result. This is overwritten and used by all logical operations
    // Keeping this global as that's what Thymeleaf needs
    private String result;

    /**
     * Here we calculate the result of the logic depending on the input.
     * Parses from String to integer to perform calculations and then back to String
     * again to return the result.
     *
     * @return String the result of the calculation
     */
    public String getResult(){

        // Check to see that the user has entered two numbers
        if (num1 != null && num2 != null) {
            // If they have, add them together.
            result = Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
        } else {
            // Else tell them to retry with numbers in both fields.
            result = "Please retry and enter a number in both input fields";
        }
        return result;
    }

    /**
     * getter for num1
     * @return String 'num1' the first number that the user enters on the /add page
     */
    public String getNum1(){
        return num1;
    }

    /**
     * getter for num2
     * @return String 'num2' the second number that the user enters on the /add page
     */
    public String getNum2(){
        return num2;
    }

    /**
     * setter for num1
     * @param num1 the first number that the user enters on the /add page
     */
    public void setNum1(String num1){
        this.num1=num1;
    }

    /**
     * setter for num2
     * @param num2 the second number that the user enters on the /add page
     */
    public void setNum2 (String num2){
        this.num2 = num2;
    }

}
