package com.unigainfo.calculator;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Semicolon07 on 1/21/2017 AD.
 */
public class ResultActivityTest {
    @Rule
    public ActivityTestRule<ResultActivity> resultActivityActivityTestRule =
            new ActivityTestRule<>(ResultActivity.class, false, false);

    @Test
    public void send_3_should_show_3(){
        Intent intent = new Intent();
        intent.putExtra(ResultActivity.INTENT_PARAM_RESULT,"3");
        resultActivityActivityTestRule.launchActivity(intent);

        onView(withId(R.id.result_textView))
                .check(matches(withText("3")));
    }

}