package com.example.task3.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.task3.R;

public class HomeActivity extends AppCompatActivity {
    TextView tv1,tv2;
    Button b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sp = getSharedPreferences("xyz", Context.MODE_PRIVATE);
        String fEmail = sp.getString("email","");
        String fPassword = sp.getString("password","");
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv1.setText(fEmail);
        tv2.setText(fPassword);
        b1 = findViewById(R.id.viewData);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,StudentActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.logout) {
            SharedPreferences sp = getSharedPreferences("state",MODE_PRIVATE);
            SharedPreferences.Editor et = sp.edit();
            et.putBoolean("loginState",false);
            et.apply();
            Intent i = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(i);
        }
        return true;
    }
}
