package com.unigainfo.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Semicolon07 on 1/21/2017 AD.
 */
// Data Driven Test

@RunWith(Parameterized.class)
public class PlusTest {
    private int firstNumber;
    private int secondNumber;
    private int expectedResult;


    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Parameterized.Parameters(name = "test case {index} : {0}+{1}={2}")
    public static List<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {2, 3, 5}
        });
    }

    public PlusTest(int firstNumber, int secondNumber, int expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Test
    public void plus_isCorrect() {
        onView(withId(R.id.firstNumber_editText))
                .perform(typeText(String.valueOf(firstNumber)));
        onView(withId(R.id.secondNumber_editText))
                .perform(typeText(String.valueOf(secondNumber)));
        onView(withId(R.id.plus_button))
                .perform(click());
        onView(withId(R.id.result_textView))
                .check(matches(withText(String.valueOf(expectedResult))));
    }

}