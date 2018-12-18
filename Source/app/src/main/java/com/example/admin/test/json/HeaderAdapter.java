package com.example.admin.test.json;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.ViewHolder> {
    ArrayList<String> arrdata;
    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_viewpager,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get().load(arrdata.get(position)).into(holder.imgHeader);
    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHeader;
        public ViewHolder(View itemView) {
            super(itemView);
            imgHeader = itemView.findViewById(R.id.img_product);
        }
    }
}
