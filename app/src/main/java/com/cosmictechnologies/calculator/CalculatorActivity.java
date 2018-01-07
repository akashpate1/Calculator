package com.cosmictechnologies.calculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity{

    private TextView expressionText;
    private String expression="";
    private TextView text;

    private Button delBtn;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

       expressionText = findViewById(R.id.expressionText);
        Button clearBtn;
        clearBtn = findViewById(R.id.clearBtn);
        delBtn = findViewById(R.id.delBtn);


        clearBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            expressionText.setText("");
            expressionText.requestFocus();
            expression="";

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



  /*  addBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View View){
           if(!number1.getText().equals("") &&!number2.getText().equals("")) {
               String num1 = number1.getText().toString();
               String num2 = number2.getText().toString();

               int n1 = Integer.parseInt(num1);
               int n2 = Integer.parseInt(num2);
               int answer=n1+n2;

             /*  Toast.makeText(CalculatorActivity.this, "Answer is " + (n1 + n2), Toast.LENGTH_SHORT).show();
                displayAlertMessage(n1+n2);

             Intent intent = new Intent(CalculatorActivity.this,ResultActivity.class);
             Bundle bundle = new Bundle();
             bundle.putInt("key_answer",answer);
             intent.putExtras(bundle);
             startActivity(intent);
           }
           else {
               Toast.makeText(CalculatorActivity.this,"Please enter both numbers.",Toast.LENGTH_SHORT);
           }
        }
    }); */
    }

    private void displayAlertMessage(int answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Answer");
        builder.setMessage("Answer is "+answer);
        builder.setPositiveButton("DISMISS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(CalculatorActivity.this,"Dismissed",Toast.LENGTH_SHORT);
            }
        });
        builder.setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               System.exit(0);
            }
        });
        builder.setCancelable(true);
        builder.show();
    }

   public void numberClicked(View view){
        int id = view.getId();
        switch (id)
        {
            case R.id.number0:
                expression = expression + "0";
                expressionText.setText(expression);
                break;
            case R.id.number1:
                expression = expression + "1";
                expressionText.setText(expression);
                break;
            case R.id.number2:
                expression = expression + "2";
                expressionText.setText(expression);
                break;
            case R.id.number3:
                expression = expression + "3";
                expressionText.setText(expression);
                break;
            case R.id.number4:
                expression = expression + "4";
                expressionText.setText(expression);
                break;
            case R.id.number5:
                expression = expression + "5";
                expressionText.setText(expression);
                break;
            case R.id.number6:
                expression = expression + "6";
                expressionText.setText(expression);
                break;
            case R.id.number7:
                expression = expression + "7";
                expressionText.setText(expression);
                break;
            case R.id.number8:
                expression = expression + "8";
                expressionText.setText(expression);
                break;
            case R.id.number9:
                expression = expression + "9";
                expressionText.setText(expression);
                break;
            case R.id.dot:
                expression = expression + ".";
                expressionText.setText(expression);
                break;
        }
   }

    public void operationClicked(View view){
       int id = view.getId();
       switch (id){
           case R.id.add:
               if(!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " + ";
               expressionText.setText(expression);}
               break;
           case R.id.minus:
               if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " - ";
               expressionText.setText(expression);}
               break;
           case R.id.multiply:
               if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " * ";
               expressionText.setText(expression);}
               break;
           case R.id.divide:
               if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/")){
               expression = expression + " / ";
               expressionText.setText(expression);}
               break;
           case R.id.equal:
                Calculator calculator = new Calculator(expression);
                //text.setText(expression);
                expression = String.valueOf(calculator.calculate());
                expressionText.setText(expression);
               break;
       }
    }
}
