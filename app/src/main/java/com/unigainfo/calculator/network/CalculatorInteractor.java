package com.unigainfo.calculator.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Semicolon07 on 1/22/2017 AD.
 */


public class CalculatorInteractor {
    private final CalculatorApi api;

    public interface CalculatorListener {
        void onSuccess(String result);
    }

    CalculatorListener listener;

    public CalculatorInteractor() {
        api = new ApiManager().getService();
    }

    public CalculatorInteractor(CalculatorListener listener) {
        this();
        this.listener = listener;
    }

    public void plus(int firstNumber, int secondNumber) {
        Call<Result> call = api.plus(firstNumber, secondNumber);
        call.enqueue(new CalculatorCallback());
    }

    final class CalculatorCallback implements Callback<Result>{

        @Override
        public void onResponse(Call<Result> call, Response<Result> response) {
            Result result = response.body();
            if (listener != null)
                listener.onSuccess(result.getResult());
        }

        @Override
        public void onFailure(Call<Result> call, Throwable t) {

        }
    }
}
