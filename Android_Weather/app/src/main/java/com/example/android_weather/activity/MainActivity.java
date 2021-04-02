package com.example.android_weather.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_weather.R;
import com.example.android_weather.adapter.NewsAdapter;
import com.example.android_weather.model.Item;
import com.example.android_weather.network.APIManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListNew;
    private List<Item> listData;
    private NewsAdapter adapter;
    private TextView tvTemp,tvDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTemp = findViewById(R.id.tvTemp);
        tvDes = findViewById(R.id.tvDes);

        // data source
        getData();

        // adapter
        listData = new ArrayList<>();
        adapter = new NewsAdapter(this,listData);

        // layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        // recycleView
        rvListNew = findViewById(R.id.rvListNew);
        rvListNew.setLayoutManager(layoutManager);
        rvListNew.setAdapter(adapter);

    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() != null){
                    listData = response.body();
                    adapter.reloadData(listData);

                    tvTemp.setText(String.valueOf(listData.get(0).getTemperature().getValue()));
                   tvDes.setText(listData.get(0).getIconPhrase());
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}