package com.unigainfo.calculator.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.unigainfo.calculator.network.ServiceUrl.PRD_BASE_URL;

/**
 * Created by Semicolon07 on 1/22/2017 AD.
 */

public class ApiManager {
    private CalculatorApi service;

    public ApiManager() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        // create client
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        try{
            ServiceUrl.BASE_URL = PRD_BASE_URL;
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ServiceUrl.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            service = retrofit.create(CalculatorApi.class);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public CalculatorApi getService() {
        return service;
    }
}
