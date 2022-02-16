package com.example.task3.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task3.R;
import com.example.task3.controller.StudentActivity;
import com.example.task3.model.Students;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    private List<Students> list = new ArrayList<>();
    public CustomAdapter(StudentActivity s , List<Students> l){
        c =s;
        list = l;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(c).inflate(R.layout.items,null);
        MyViewHolder viewHolder = new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv1.setText("Name: "+list.get(position).getNames());
        holder.tv2.setText("Address:"+list.get(position).getAddress());
        holder.tv3.setText("Faculty:"+list.get(position).getFaculty());
        holder.tv4.setText("Semester:"+list.get(position).getSemester());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3,tv4;
        public MyViewHolder(View convertView){
            super(convertView);
            tv1 = convertView.findViewById(R.id.name);
            tv2 = convertView.findViewById(R.id.address);
            tv3 = convertView.findViewById(R.id.faculty);
            tv4 = convertView.findViewById(R.id.semester);
        }
    }
}
