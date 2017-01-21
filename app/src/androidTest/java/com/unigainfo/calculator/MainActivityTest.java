package com.unigainfo.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Semicolon07 on 1/21/2017 AD.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void plus_2_2_should_be_4(){
        inputFirstNumber("2");
        inputSecondNumber("2");
        performClick(R.id.plus_button);
        checkResult("4");
    }

    @Test
    public void minus_2_1_should_be_1(){
        inputFirstNumber("2");
        inputSecondNumber("1");
        performClick(R.id.minus_button);
        checkResult("1");
    }

    @Test
    public void multiply_2_5_should_be_10(){
        inputFirstNumber("2");
        inputSecondNumber("5");
        performClick(R.id.multiply_button);
        checkResult("10");
    }

    @Test
    public void divide_10_2_should_be_5(){
        inputFirstNumber("10");
        inputSecondNumber("2");
        performClick(R.id.divide_button);
        checkResult("5");
    }

    @Test
    public void divide_10_0_should_be_throw_DivideByZeroException(){
        inputFirstNumber("10");
        inputSecondNumber("0");
        performClick(R.id.divide_button);
        checkResult("หาร 0 ไม่ได้นะ");
    }

    public void performClick(int buttonResId){
        onView(withId(buttonResId))
                .perform(click());
    }

    public void inputFirstNumber(String value){
        onView(withId(R.id.firstNumber_editText))
                .perform(typeText(value));
    }

    public void inputSecondNumber(String value){
        onView(withId(R.id.secondNumber_editText))
                .perform(typeText(value));
    }

    public void checkResult(String result){
        onView(withId(R.id.result_textView))
                .check(matches(withText(result)));
    }
}