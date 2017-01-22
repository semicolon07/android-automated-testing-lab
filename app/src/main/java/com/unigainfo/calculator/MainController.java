package com.unigainfo.calculator;

import com.unigainfo.calculator.exception.DivideByZeroException;

/**
 * Created by Semicolon07 on 1/22/2017 AD.
 */

public class MainController {
    MainView mainView;
    private int firstNumber;
    private int secondNumber;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public void plus(){
        Calculator calculator = new Calculator();
        int result = calculator.plus(firstNumber,secondNumber);
        sendResult(result);
    }

    public void minus(){
        Calculator calculator = new Calculator();
        int result = calculator.minus(firstNumber,secondNumber);
        sendResult(result);
    }

    public void multiply(){
        Calculator calculator = new Calculator();
        int result = calculator.multiply(firstNumber,secondNumber);
        sendResult(result);
    }

    public void divide(){
        Calculator calculator = new Calculator();
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
}
