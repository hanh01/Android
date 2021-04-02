package com.example.android_network.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_network.R;
import com.example.android_network.adapter.NewsAdapter;
import com.example.android_network.model.Item;
import com.example.android_network.network.APIManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListNewsActivity extends AppCompatActivity {

    RecyclerView rvListView;
    List<Item> listData;
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        // data source
          getListData();

        // adapter
        listData = new ArrayList<>();
        adapter = new NewsAdapter(ListNewsActivity.this, listData);

        //Layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);


        // RecycleView
        rvListView = findViewById(R.id.rvListNew);
        rvListView.setLayoutManager(layoutManager);
        rvListView.setAdapter(adapter);


    }

    private  void getListData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(response.body() != null){
                    listData = response.body();
                    adapter.reloadData(listData);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(ListNewsActivity.this,"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
