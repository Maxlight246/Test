package com.example.admin.test.json;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.test.R;

import java.util.ArrayList;

public class ProductAdapter2 extends RecyclerView.Adapter<ProductAdapter2.ProductViewHolder> {
    ArrayList <Inventories> arrdata;
    Context context;


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Inventories inventories = arrdata.get(position);
        holder.tvInventories.setText(inventories.branchName);

    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvInventories;
        public ProductViewHolder(View itemView) {
            super(itemView);
            tvInventories = itemView.findViewById(R.id.tv_inventories);
        }
    }
}
