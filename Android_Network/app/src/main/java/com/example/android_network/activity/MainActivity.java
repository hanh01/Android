package com.example.android_network.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android_network.R;
import com.example.android_network.model.Item;
import com.example.android_network.network.APIManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvDes, tvDate;
    ImageView ivCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        ivCover = findViewById(R.id.ivCover);
        tvDate = findViewById(R.id.tvDate);

        getData();
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getItemData().enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item model = response.body();
                tvDes.setText(model.getContent().getDescription());
                tvTitle.setText(model.getTitle());
                tvDate.setText(model.getDate());
                Glide.with(MainActivity.this).load(model.getImage()).into(ivCover);
                Log.d("Hanh_test","Success");
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.d("Hanh_test","Error" + t);
            }
        });
    }
}