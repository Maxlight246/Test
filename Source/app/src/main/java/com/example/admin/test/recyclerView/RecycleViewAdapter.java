package com.example.admin.test.recyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.test.Danhsachsinhvien.Sinhvien;
import com.example.admin.test.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.StudentViewHolder> {

    ArrayList<Sinhvien> data;
    Context context;
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dssv_layout,parent,false);
        StudentViewHolder studentViewHolder= new StudentViewHolder(view);

        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
           Sinhvien sinhvien = data.get(position);
           holder.tvName.setText(sinhvien.getTen());
           holder.tvTuoi.setText(Integer.toString(sinhvien.getTuoi()) );
           holder.tvDiachi.setText(sinhvien.getDiachi());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvTuoi,tvDiachi;

        public StudentViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_ten);
            tvTuoi = itemView.findViewById(R.id.tv_tuoi);
            tvDiachi = itemView.findViewById(R.id.tv_diachi);
        }
    }
}
