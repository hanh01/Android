package com.example.dothihonghanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dothihonghanh.database.AppDatabase;
import com.example.dothihonghanh.entity.Product;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edName,edQuantity;
    Button btAdd,btView;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        edName = findViewById(R.id.edName);
        edQuantity = findViewById(R.id.edQuantity);
        btAdd = findViewById(R.id.btAdd);
        btView = findViewById(R.id.btView);

        InitView();

    }

    private void InitView(){
        btAdd.setOnClickListener(this);
        btView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAdd:
                addProduct();
                break;
            case R.id.btView:
                viewProduct();
                break;
            default:
                break;
        }
    }

    public void addProduct(){
        Product product = new Product();
        product.setName(edName.getText().toString());
        product.setQuantity(Integer.valueOf(edQuantity.getText().toString()));
        db.userDao().Insert(product);
    }


    public void viewProduct(){
        Intent view = new Intent(MainActivity.this,ListActivity.class);
        startActivity(view);    }
}