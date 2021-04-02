package com.example.android_weather.network;

import com.example.android_weather.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER_URL = "http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=9Bmmh4VCCIFyTrXcJVAm9KFkSYIhfWfL&language=vi-vn&metric=true")
    Call<List<Item>> getListData();
}
