package com.unigainfo.calculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Semicolon07 on 1/21/2017 AD.
 */

public class CalculatorMultiplyTest {
    //Arrange
    Calculator calculator = new Calculator();

    @Before
    public void setup(){

    }

    @Test
    public void multiply_2_2_should_be_4(){
        int result = calculator.multiply(2,2);
        int expect = 4;
        assertEquals(expect,result);
    }

    @Test
    public void multiply_4_5_should_be_16(){
        int result = calculator.multiply(4,4);
        int expect = 16;
        assertEquals(expect,result);
    }
}
