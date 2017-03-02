package com.unigainfo.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Semicolon07 on 1/22/2017 AD.
 */
public class MainControllerTest {
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
    public void plus() throws InterruptedException {
        //Arrange
        SpyMainView view = new SpyMainView();
        MainController mainController = new MainController(view);

        //Act
        mainController.plus();

        //Assert ?
        assertTrue("Method sendResult must be called",view.isCalled());
    }

    @Test
    public void minus() throws InterruptedException {
        //Arrange
        SpyMainView view = new SpyMainView();
        MainController mainController = new MainController(view);

        //Act
        mainController.minus();


        //Assert ?
        assertTrue("Method sendResult must be called",view.isCalled());
    }

    @Test
    public void multiply() throws InterruptedException {
        //Arrange
        SpyMainView view = new SpyMainView();
        MainController mainController = new MainController(view);

        //Act
        mainController.multiply();

        //Assert ?
        assertTrue("Method sendResult must be called",view.isCalled());
    }


}