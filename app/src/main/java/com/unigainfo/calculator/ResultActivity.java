package com.unigainfo.calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public static final String INTENT_PARAM_RESULT = "INTENT_PARAM_RESULT";
    private String calculateResult;

    public static Intent callingIntent(Context context, String result) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(INTENT_PARAM_RESULT, result);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calculateResult = getIntent().getStringExtra(INTENT_PARAM_RESULT);

        //Bind result
        TextView resultTextView = (TextView) findViewById(R.id.result_textView);
        resultTextView.setText(calculateResult);
    }
}
