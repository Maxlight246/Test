package com.example.admin.test.recyclerView.contact;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.test.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    public static ArrayList<GoProContact> arrdata;
    Context context;
    OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final GoProContact goProContact = arrdata.get(position);
        holder.tvName.setText(goProContact.getName());
        holder.tvAge.setText(Integer.toString(goProContact.getAge()));
        holder.tvAddr.setText(goProContact.getAddr());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gui ve position cho activity
                onRecyclerViewItemClickListener.OnItemClick(position);

//                Intent intent = new Intent(context,AddActivity.class);
//                intent.putExtra("contact1",goProContact);
//                intent.putExtra("positon",position);
//                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvAge,tvAddr;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_ctname);
            tvAge=itemView.findViewById(R.id.tv_ctage);
            tvAddr=itemView.findViewById(R.id.tv_ctaddr);
        }
    }
}
