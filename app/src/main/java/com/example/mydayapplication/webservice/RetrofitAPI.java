package com.example.mydayapplication.webservice;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {

    Retrofit retrofit;

    public Retrofit getRetrofit() {

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://backtowork.icfoss.qleapbs.com/diary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
