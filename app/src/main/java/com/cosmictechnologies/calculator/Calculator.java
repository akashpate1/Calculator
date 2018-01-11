package com.cosmictechnologies.calculator;

import static com.cosmictechnologies.calculator.opCode.ADD;
import static com.cosmictechnologies.calculator.opCode.DIVIDE;
import static com.cosmictechnologies.calculator.opCode.MINUS;
import static com.cosmictechnologies.calculator.opCode.MULTIPLY;
import static com.cosmictechnologies.calculator.opCode.NOTHING;


enum opCode{
    ADD,MINUS,DIVIDE,MULTIPLY,NOTHING
}
 class Calculator {

    private double leftVal=0.0;
    private double rightVal=0.0;
    private opCode opCode = NOTHING;
    private String result;
    private String expression;

    Calculator(String expression){
        this.expression = expression;
        String[] expressions = expression.split(" ");
        int len = expressions.length;
        if(len>0)
            leftVal = Double.parseDouble(expressions[0]);
        if (len>1)
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
                default:
                    opCode = NOTHING;
            }
        if (len>2)
            rightVal = Double.parseDouble(expressions[2]);





    }
     String calculate(){
        switch (opCode){
            case ADD:
                if (rightVal!=0)
                result = String.valueOf(leftVal + rightVal);
                else
                    result = String.valueOf(leftVal);
                break;
            case MINUS:
                if (rightVal!=0)
                result = String.valueOf(leftVal - rightVal);
                else
                    result = String.valueOf(leftVal);
                break;
            case DIVIDE:
                if (rightVal!=0)
                result = String.valueOf(leftVal / rightVal);
                else
                    result = String.valueOf(leftVal);
                break;
            case MULTIPLY:
                if (rightVal!=0)
                result = String.valueOf(leftVal * rightVal);
                else
                    result=String.valueOf(leftVal);
                break;
            case NOTHING:
                result = expression;
        }
    return result;
    }

}
