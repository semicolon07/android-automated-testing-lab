package com.unigainfo.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.unigainfo.calculator.exception.DivideByZeroException;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private Button plusButton, minusButton, multiplyButton, divideButton;
    private Calculator calculator;
    private int firstNumber,secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        calculator = new Calculator();
        //Bind View
        firstNumberEditText = (EditText) findViewById(R.id.firstNumber_editText);
        secondNumberEditText = (EditText) findViewById(R.id.secondNumber_editText);

        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        multiplyButton = (Button) findViewById(R.id.multiply_button);
        divideButton = (Button) findViewById(R.id.divide_button);

        //Bind Listener
        plusButton.setOnClickListener(calculatorActionButtonListener);
        minusButton.setOnClickListener(calculatorActionButtonListener);
        multiplyButton.setOnClickListener(calculatorActionButtonListener);
        divideButton.setOnClickListener(calculatorActionButtonListener);

    }

    private void setupText(){
        String firstNumberText = firstNumberEditText.getText().toString();
        String secondNumberText = secondNumberEditText.getText().toString();

        firstNumber = Integer.valueOf(firstNumberText);
        secondNumber = Integer.valueOf(secondNumberText);
    }


    // Listener
    public final View.OnClickListener calculatorActionButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setupText();
            switch (v.getId()) {
                case R.id.plus_button:
                    plus();
                    break;
                case R.id.minus_button:
                    minus();
                    break;
                case R.id.multiply_button:
                    multiply();
                    break;
                case R.id.divide_button:
                    divide();
                    break;
                default:
            }
        }
    };

    private void divide() {
        try{
            int result = calculator.divide(firstNumber,secondNumber);
            showResult(result);
        }catch (DivideByZeroException e){
            showResult("หาร 0 ไม่ได้นะ");
        }
    }

    private void showResult(String result) {
        Intent intent = ResultActivity.callingIntent(this, result);
        startActivity(intent);
    }

    private void multiply() {
        int result = calculator.multiply(firstNumber,secondNumber);
        showResult(result);
    }

    private void minus() {
        int result = calculator.minus(firstNumber,secondNumber);
        showResult(result);
    }

    private void plus(){
        int result = calculator.plus(firstNumber,secondNumber);
        showResult(result);
    }


    private void showResult(int result) {
        Intent intent = ResultActivity.callingIntent(this, String.valueOf(result));
        startActivity(intent);
    }
}
