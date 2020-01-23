package com.example.mydayapplication.webservice;

import com.example.mydayapplication.model.DiaryRequest;
import com.example.mydayapplication.model.DiaryResponse;
import com.example.mydayapplication.model.MainRequest;
import com.example.mydayapplication.model.MainResponse;
import com.example.mydayapplication.model.MoneyGetResponse;
import com.example.mydayapplication.model.MoneyPostRequest;
import com.example.mydayapplication.model.MoneyPostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @POST("diarydaily")
    Call<DiaryResponse> createDiaryData(@Body DiaryRequest diaryRequest);

    @GET("diarydaily")
    Call<List<MainResponse>> getDiaryData(@Query("userId") String uid);

   /* @POST("moneydaily")
    Call<MoneyPostResponse> createMoneyData(@Body MoneyPostRequest moneyPostRequest);


    //want the controller of get function
    @GET("moneygetdaily")
    Call<MoneyGetResponse> viewMoneyData(@Body MoneyGetResponse moneyGetResponse);*/
}