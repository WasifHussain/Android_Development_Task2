package com.example.task3.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task3.R;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLoginStatus();
        e1 = findViewById(R.id.txtEmail);
        e2 = findViewById(R.id.txtPassword);
        b1 = findViewById(R.id.btnLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("xyz", Context.MODE_PRIVATE);
                String fEmail = sp.getString("email","");
                String fPassword = sp.getString("password","");
                String uEmail = e1.getText().toString();
                String uPassword = e2.getText().toString();
                if (fEmail.equals(uEmail) && fPassword.equals(uPassword)){
                    Toast.makeText(MainActivity.this,"Logged In Successfully!",Toast.LENGTH_LONG).show();

                    SharedPreferences lp = getSharedPreferences("state",MODE_PRIVATE);
                    SharedPreferences.Editor et = lp.edit();
                    et.putBoolean("loginState",true);
                    et.apply();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect Credentials!",Toast.LENGTH_LONG).show();
                }
            }
        });
       b2 = findViewById(R.id.btnSignup);
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, RegisterActivity.class);
               startActivity(i);
           }
       });
    }
    private void checkLoginStatus() {
        SharedPreferences sp = getSharedPreferences("state",MODE_PRIVATE);
        boolean state = sp.getBoolean("loginState",false);
        if (state){
            Intent i = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(i);
        }
    }
}