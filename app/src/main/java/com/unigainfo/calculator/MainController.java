package com.unigainfo.calculator;

import android.support.annotation.NonNull;

import com.unigainfo.calculator.exception.DivideByZeroException;
import com.unigainfo.calculator.network.CalculatorInteractor;

/**
 * Created by Semicolon07 on 1/22/2017 AD.
 */

public class MainController implements CalculatorInteractor.CalculatorListener {
    MainView mainView;
    private int firstNumber;
    private int secondNumber;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public void plus(){
        Calculator calculator = getCalculator();
        int result = calculator.plus(firstNumber,secondNumber);
        sendResult(result);
        //CalculatorInteractor calculatorInteractor = new CalculatorInteractor(this);
        //calculatorInteractor.plus(firstNumber,secondNumber);
    }

    @NonNull
    private Calculator getCalculator() {
        return new Calculator();
    }

    public void minus(){
        Calculator calculator = getCalculator();
        int result = calculator.minus(firstNumber,secondNumber);
        sendResult(result);
    }

    public void multiply(){
        Calculator calculator = getCalculator();
        int result = calculator.multiply(firstNumber,secondNumber);
        sendResult(result);
    }

    public void divide(){
        Calculator calculator = getCalculator();
        try{
            int result = calculator.divide(firstNumber,secondNumber);
            sendResult(result);
        }catch (DivideByZeroException e){
            sendResult("หาร 0 ไม่ได้นะ");
        }
    }

    private void sendResult(int result) {
        mainView.sendResult(String.valueOf(result));
    }

    private void sendResult(String result){
        mainView.sendResult(result);
    }

    public void setupInput(String firstNumberText, String secondNumberText) {
        this.firstNumber = Integer.valueOf(firstNumberText);
        this.secondNumber = Integer.valueOf(secondNumberText);
    }

    @Override
    public void onSuccess(String result) {
        sendResult(result);
    }
}
