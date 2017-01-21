package com.unigainfo.calculator;


import com.unigainfo.calculator.exception.DivideByZeroException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorDivideTest {

    //Arrange
    Calculator calculator = new Calculator();

    @Before
    public void setup(){

    }

    @Test
    public void divide_2_2_should_be_1(){
        int result = calculator.divide(2,2);
        int expect = 1;
        assertEquals(expect,result);
    }

    @Test
    public void divide_10_2_should_be_5(){
        int result = calculator.divide(10,2);
        int expect = 5;
        assertEquals(expect,result);
    }


    @Test(expected = DivideByZeroException.class)
    public void divide_10_2_should_be_throw_exception(){
        int result = calculator.divide(10,0);
        int expect = 0;
        assertEquals(expect,result);
    }
}
