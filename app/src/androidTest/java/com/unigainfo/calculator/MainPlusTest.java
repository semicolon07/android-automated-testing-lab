package com.unigainfo.calculator;

import android.content.Intent;
import android.support.test.espresso.core.deps.guava.base.Charsets;
import android.support.test.espresso.core.deps.guava.io.Resources;
import android.support.test.rule.ActivityTestRule;

import com.unigainfo.calculator.network.ServiceUrl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Semicolon07 on 1/21/2017 AD.
 */
public class MainPlusTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    private MockWebServer server;

    @Before
    public void startServer() throws Exception {
        server = new MockWebServer();
        server.start();
        ServiceUrl.BASE_URL = server.url("/").toString();
    }
    @After
    public void stopServer() throws Exception {
        server.shutdown();
    }
    private String getDataFromFile(String resource) throws IOException {
        return Resources.toString(Resources.getResource(resource), Charsets.UTF_8);
    }

    @Test
    public void plus_2_3_should_be_5() throws IOException {
        String fileName = "result_plus.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(getDataFromFile(fileName)));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        inputFirstNumber("2");
        inputSecondNumber("3");
        performClick(R.id.plus_button);
        checkResult("5");
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