package com.unigainfo.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Semicolon07 on 1/22/2017 AD.
 */
public class MainControllerDivideTest {
    class SpyMainView implements MainView{

        private boolean called;

        @Override
        public void sendResult(String result) {
            called = true;
        }

        public boolean isCalled() {
            return called;
        }
    }

    @Test
    public void divide_with_zero_exception_() throws InterruptedException {
        //Arrange
        SpyMainView view = new SpyMainView();
        MainController mainController = new MainController(view);
        mainController.setupInput("222","0");

        //Act
        mainController.divide();

        //Assert ?
        assertTrue("Method sendResult must be called",view.isCalled());
    }

    @Test
    public void divide_throwDivideByZero() throws InterruptedException {
        //Arrange
        SpyMainView view = new SpyMainView();
        MainController mainController = new MainController(view);
        mainController.setupInput("222","2");

        //Act
        mainController.divide();

        //Assert ?
        assertTrue("Method sendResult must be called",view.isCalled());
    }

}