package com.example.android_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText edUser, edPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassWord);
        btLogin = findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });
    }

    private void goToMain(){
        Intent shipper = new Intent(LoginActivity.this, MainActivity.class);
        shipper. putExtra("USERNAME", edUser.getText().toString());
        shipper.putExtra("PASSWORD",edPassword.getText().toString());
        startActivity(shipper);
    }
}