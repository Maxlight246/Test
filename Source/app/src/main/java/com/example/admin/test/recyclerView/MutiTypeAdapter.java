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

public class MutiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Object> arrdata;
    Context context;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.item_listview_layout,parent,false);
            return new StudentViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_hearder,parent,false);
            return new HeaderViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
           if (arrdata.get(position)instanceof String){
               ((HeaderViewHolder)holder).tvHeader.setText((String)arrdata.get(position));
           }else {
               Sinhvien sinhvien = (Sinhvien)arrdata.get(position);
               ((StudentViewHolder)holder).tvName.setText(sinhvien.getTen());
           }
    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    @Override
    public int getItemViewType(int position) {
        // neu ma la string thi ve 0
      if (arrdata.get(position)instanceof String){
          return 0;
      }else {
          // neu ma la Student thi ve 1
          return 1;
      }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tv_header);
        }
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvPrefix;
        public StudentViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrefix = itemView.findViewById(R.id.tv_prefix);
        }
    }
}
