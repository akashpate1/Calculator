package com.cosmictechnologies.calculator;

import static com.cosmictechnologies.calculator.opCode.ADD;
import static com.cosmictechnologies.calculator.opCode.DIVIDE;
import static com.cosmictechnologies.calculator.opCode.MINUS;
import static com.cosmictechnologies.calculator.opCode.MULTIPLY;


enum opCode{
    ADD,MINUS,DIVIDE,MULTIPLY
}

public class Calculator {

    private double leftVal;
    private double rightVal;
    private opCode opCode;
    private double result;


    Calculator(String expression){
        String[] expressions = expression.split(" ");
        leftVal = Double.parseDouble(expressions[0]);
        rightVal = Double.parseDouble(expressions[2]);
        switch(expressions[1]){
            case "+":
                opCode = ADD;
                break;
            case "-":
                opCode = MINUS;
                break;
            case "*":
                opCode = MULTIPLY;
                break;
            case "/":
                opCode = DIVIDE;
                break;
        }

    }

    public double calculate(){
        switch (opCode){
            case ADD:
                result = leftVal + rightVal;
                break;
            case MINUS:
                result = leftVal - rightVal;
                break;
            case DIVIDE:
                result = leftVal / rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
        }
    return result;
    }

}
