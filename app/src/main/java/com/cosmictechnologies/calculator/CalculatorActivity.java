package com.cosmictechnologies.calculator;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity{

    private TextView expressionText;
    private String expression="";
    private String displayExpression="";
    private TextView text;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

       expressionText = findViewById(R.id.expressionText);
       text = findViewById(R.id.text);
        Button clearBtn;
        clearBtn = findViewById(R.id.clearBtn);
        Button delBtn = findViewById(R.id.delBtn);


        clearBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            expressionText.setText("");
            expressionText.requestFocus();
            expression="";
            text.setText("");
            displayExpression = "";

        }

    });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(expression!=null && expression.length()>0 )
                expression = expression.substring(0,expression.length()-1);
                expressionText.setText(expression);
            }
        });




    }



   public void numberClicked(View view){
        int id = view.getId();
        switch (id)
        {
            case R.id.number0:
                expression = expression + "0";
                displayExpression = displayExpression + "0";
                expressionText.setText(displayExpression);
                break;
            case R.id.number1:
                expression = expression + "1";
                displayExpression = displayExpression + "1";
                expressionText.setText(displayExpression);
                break;
            case R.id.number2:
                expression = expression + "2";
                displayExpression = displayExpression + "2";
                expressionText.setText(displayExpression);
                break;
            case R.id.number3:
                expression = expression + "3";
                displayExpression = displayExpression + "3";
                expressionText.setText(displayExpression);
                break;
            case R.id.number4:
                expression = expression + "4";
                displayExpression = displayExpression + "4";
                expressionText.setText(displayExpression);
                break;
            case R.id.number5:
                expression = expression + "5";
                displayExpression = displayExpression + "5";
                expressionText.setText(displayExpression);
                break;
            case R.id.number6:
                expression = expression + "6";
                displayExpression = displayExpression + "6";
                expressionText.setText(displayExpression);
                break;
            case R.id.number7:
                expression = expression + "7";
                displayExpression = displayExpression + "7";
                expressionText.setText(displayExpression);
                break;
            case R.id.number8:
                expression = expression + "8";
                displayExpression = displayExpression + "8";
                expressionText.setText(displayExpression);
                break;
            case R.id.number9:
                expression = expression + "9";
                displayExpression = displayExpression + "9";
                expressionText.setText(displayExpression);
                break;
            case R.id.dot:
                expression = expression + ".";
                displayExpression = displayExpression + ".";
                expressionText.setText(displayExpression);
                break;
        }
   }

    public void operationClicked(View view){
       int id = view.getId();
       switch (id){
           case R.id.add:
               if(!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " + ";
               displayExpression = "";
               expressionText.setText(displayExpression);
               text.setText(expression);}
               break;
           case R.id.minus:
               if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " - ";
               displayExpression = "";
               expressionText.setText(displayExpression);
               text.setText(expression);}
               break;
           case R.id.multiply:
               if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " * ";
               displayExpression = "";
               expressionText.setText(displayExpression);
               text.setText(expression);}
               break;
           case R.id.divide:
               if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " / ";
               displayExpression = "";
               expressionText.setText(displayExpression);
               text.setText(expression);}
               break;
           case R.id.equal:

                text.setText(expression);
                if (!expression.equals("")) {
                    Calculator calculator = new Calculator(expression);
                    expression = calculator.calculate();
                    displayExpression = expression;
                }
                else
                    expression="0.0";
                expressionText.setText(expression);
               break;
       }
    }
}
