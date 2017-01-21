package com.unigainfo.calculator;


import com.unigainfo.calculator.exception.DivideByZeroException;

public class Calculator {

    public int plus(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public int divide(int firstNumber, int secondNumber) {
        if(secondNumber == 0)
            throw new DivideByZeroException();

        return firstNumber / secondNumber;
    }
}
