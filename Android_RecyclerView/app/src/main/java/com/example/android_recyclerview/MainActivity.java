package com.example.android_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvProduct;
    List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data
        initData();

        //Layout
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);

        //Adapter
        ProductAdapter adapter = new ProductAdapter(this,listProduct);

        //Recycler View
        rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);


    }

    private void initData(){
        listProduct.add(new Product("Product1","500.000",R.drawable.img1));
        listProduct.add(new Product("Product2","600.000",R.drawable.img2));
        listProduct.add(new Product("Product3","700.000",R.drawable.img3));
        listProduct.add(new Product("Product4","800.000",R.drawable.img4));
    }
}