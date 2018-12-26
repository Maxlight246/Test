package com.example.admin.test.network.ListProduct;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder> {
    List<Product> arrdata;
    Context context;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = arrdata.get(position);
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText(""+ product.getBasePrice());
        Picasso.get().load(product.image).into(holder.imgProduct);

    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvPrice;
        ImageView imgProduct;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_product_name);
            tvPrice = itemView.findViewById(R.id.tv_product_price);
            imgProduct = itemView.findViewById(R.id.img_product);
        }
    }
}
