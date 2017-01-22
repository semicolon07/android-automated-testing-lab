package com.unigainfo.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

interface MainView{
    void sendResult(String result);
}

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private Button plusButton, minusButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        //Bind View
        firstNumberEditText = (EditText) findViewById(R.id.firstNumber_editText);
        secondNumberEditText = (EditText) findViewById(R.id.secondNumber_editText);

        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        multiplyButton = (Button) findViewById(R.id.multiply_button);
        divideButton = (Button) findViewById(R.id.divide_button);

        //Bind Listener
        plusButton.setOnClickListener(onPlusButtonClickListener);
        minusButton.setOnClickListener(onMinusButtonClickListener);
        multiplyButton.setOnClickListener(onMultiplyButtonClickListener);
        divideButton.setOnClickListener(onDivideButtonClickListener);

    }

    private MainController getMainController(){
        String firstNumberText = firstNumberEditText.getText().toString();
        String secondNumberText = secondNumberEditText.getText().toString();

        MainController mainController = new MainController(this);
        mainController.setupInput(firstNumberText,secondNumberText);

        return mainController;
    }

    // Listener
    public final View.OnClickListener onPlusButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainController mainController = getMainController();
            mainController.plus();
        }
    };
    public final View.OnClickListener onMinusButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainController mainController = getMainController();
            mainController.minus();
        }
    };

    public final View.OnClickListener onMultiplyButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainController mainController = getMainController();
            mainController.multiply();
        }
    };
    public final View.OnClickListener onDivideButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainController mainController = getMainController();
            mainController.divide();
        }
    };

    @Override
    public void sendResult(String result) {
        Intent intent = ResultActivity.callingIntent(this, result);
        startActivity(intent);
    }
}
