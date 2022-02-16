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
import java.util.Arrays;
import java.util.List;


public class StudentActivity extends AppCompatActivity {
    private RecyclerView rv;
    String names, address, faculty, semester ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        readStudentData();
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CustomAdapter(StudentActivity.this,list));
    }
    private List<Students> list = new ArrayList<>();
    private void readStudentData(){
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String csvLine = " ";
        try{

            while ((csvLine = reader.readLine()) != null) {
            Log.e("read line",csvLine.toString());
               String[] values = csvLine.split(",");
                Students students = new Students();
                students.setNames(values[0]);
                students.setAddress(values[1]);
                students.setFaculty(values[2]);
                students.setSemester(values[3]);
//                    names = values[0];
//                    address = values[1];
//                    faculty = values[2];
//                    semester = values[3];
                String str = Arrays.toString(values);
               list.add(students);

            }
        }catch (Exception e){
            Log.e("error reading file",e.toString());
        }
    }
}
