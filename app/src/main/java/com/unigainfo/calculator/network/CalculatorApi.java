package com.unigainfo.calculator.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Semicolon07 on 1/22/2017 AD.
 */

public interface CalculatorApi {
    @GET(ServiceUrl.PLUS)
    Call<Result> plus(@Query("first_number") int firstNumber,
                      @Query("second_number") int secondNumber);
}

class Result{
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
