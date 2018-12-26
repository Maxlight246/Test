package com.example.admin.test.testkt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.test.R;
import com.example.admin.test.testkt.Object.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter3 extends RecyclerView.Adapter<ProductAdapter3.ViewHolder> {

    ArrayList<Product> arrdata;
    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           Product product = arrdata.get(position);
           holder.tvName.setText(product.getName());
           holder.tvId.setText(""+product.getId());
           holder.tvPrice.setText(""+product.getPrice());
        Picasso.get().load(product.getImages()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvId, tvPrice;
        ImageView imgProduct;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_product_name);
            tvId = itemView.findViewById(R.id.tv_product_id);
            tvPrice = itemView.findViewById(R.id.tv_product_price);
            imgProduct = itemView.findViewById(R.id.img_product);
        }
    }
}
