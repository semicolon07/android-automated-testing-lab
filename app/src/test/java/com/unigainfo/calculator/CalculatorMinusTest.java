package com.unigainfo.calculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Semicolon07 on 1/21/2017 AD.
 */

public class CalculatorMinusTest {
    //Arrange
    Calculator calculator = new Calculator();

    @Before
    public void setup(){

    }

    @Test
    public void minus_1_1_should_be_0(){
        int result = calculator.minus(1,1);
        int expect = 0;
        assertEquals(expect,result);
    }

    @Test
    public void minus_3_2_should_be_1(){
        int result = calculator.minus(3,2);
        int expect = 1;
        assertEquals(expect,result);
    }
}
