package com.safebear.springbootwebapp.functions;

/**
 * Created by CCA_Student on 05/03/2018.
 */
public class Calculator {

    private String num1;
    private String num2;
    private String result;



    public String getResult(){
        result = Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
        return result;
    }

    public String getNum1(){
        return num1;
    }

    public String getNum2(){
        return num2;
    }

    public void setNum1(String num1){
        this.num1=num1;
    }

    public void setNum2 (String num2){
        this.num2 = num2;
    }

}
