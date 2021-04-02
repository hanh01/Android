package com.example.android_network.network;

import com.example.android_network.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER_URL = "http://api-demo-anhth.herokuapp.com/";

    @GET("data.json")
    Call<Item> getItemData();

    @GET("datas.json")
    Call<List<Item>> getListData();
}
