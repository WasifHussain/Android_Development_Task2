package com.example.task3.controller;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task3.R;
import com.example.task3.model.Students;
import com.example.task3.view.CustomAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class StudentActivity extends AppCompatActivity {
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        readStudentData();
        rv = findViewById(R.id.rv);
        
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CustomAdapter(StudentActivity.this,names,address,faculty,semester));
    }
    private List<Students> students = new ArrayList<>();

    Students dm1 = new Students();
    String names = dm1.getName();
    String address = dm1.getAddress();
    String faculty = dm1.getFaculty();
    int semester = dm1.getSemester();
    private void readStudentData(){
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String csvLine=" ";
        try{
            while ((csvLine = reader.readLine()) != null) {
                String[] tokens = csvLine.split(",");
                Students dm = new Students();
                dm.setName(tokens[0]);
                dm.setAddress(tokens[1]);
                dm.setFaculty(tokens[2]);
                dm.setSemester(Integer.parseInt(tokens[4]));
                students.add(dm);
            }
        }catch (IOException e){
            Log.wtf("MyActivity","Error reading data file on line"+csvLine,e);
            e.printStackTrace();

        }
    }
}
