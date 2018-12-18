package com.example.admin.test.test2;

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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<Sinhvien> arrdata;
    Context context;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_chat_right_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sinhvien sinhvien = arrdata.get(position);
        holder.tvchat.setText(sinhvien.getTen());


    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvchat;
        public ViewHolder(View itemView) {
            super(itemView);
            tvchat = itemView.findViewById(R.id.tv_chat_right);
        }
    }
}
