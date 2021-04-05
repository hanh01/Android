package com.example.android_file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText edUser, edPass;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edPass = findViewById(R.id.edPass);
        edUser = findViewById(R.id.edUser);
        btLogin = findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });
        if(checkLogin()){
            goToMain();
            Log.d("Tag","success");
        }
    }

    private void onLogin(){
       goToMain();
       saveStateLogin();
    }

    private void goToMain(){
        Intent shipper = new Intent(this,MainActivity.class);
        startActivity(shipper);
        finish();
    }

    private boolean checkLogin(){
        SharedPreferences setting = getSharedPreferences("Android_File",MODE_PRIVATE);
        String username = setting.getString("username",null);
        if(username != null){
            return true;
        }else{
            return false;
        }
    }

    private void saveStateLogin(){
        SharedPreferences setting = getSharedPreferences("Android_File",MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putString("username",edUser.getText().toString());
        editor.putString("password",edPass.getText().toString());
        editor.commit();

    }
}