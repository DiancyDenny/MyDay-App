package com.example.mydayapplication.webservice;

import com.example.mydayapplication.model.DiaryRequest;
import com.example.mydayapplication.model.DiaryResponse;
import com.example.mydayapplication.model.MainRequest;
import com.example.mydayapplication.model.MainResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("diarydaily")
    Call<DiaryResponse> createDiaryData(@Body DiaryRequest diaryRequest);


    @GET("diarydaily")
    Call<MainResponse> viewDiaryData(@Body MainRequest mainRequest);
}