package com.unigainfo.calculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Semicolon07 on 1/21/2017 AD.
 */

public class CalculatorAddTest {
    //Arrange
    Calculator calculator = new Calculator();

    @Before
    public void setup(){

    }

    @Test
    public void plus_2_2_should_be_4(){
        //Act
        int result = calculator.plus(2,2);
        //Assert
        int expect = 4;
        assertEquals(expect,result);
    }

    @Test
    public void plus_2_3_should_be_5(){
        //Act
        int result = calculator.plus(2,3);
        //Assert
        int expect = 5;
        assertEquals(expect,result);
    }
}
