package com.example.admin.test.recyclerView.ChatScreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.test.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Message> arrdata;
    Context context;




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_right_layout,parent,false);
            return new RightViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_left_layout,parent,false);
            return new LeftViewHolder(view);
        }



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (arrdata.get(position).getVitri()==1){
            ((RightViewHolder)holder).tvChatRight.setText(arrdata.get(position).getContext());

        }else {
            ((LeftViewHolder)holder).tvChatLeft.setText(arrdata.get(position).getContext());
        }

    }

    @Override
    public int getItemCount() {
        return arrdata.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (arrdata.get(position).getVitri()==1){
            return 1;
        }else {
            return 0;
        }
    }

    class RightViewHolder extends RecyclerView.ViewHolder {
        TextView tvChatRight;
        public RightViewHolder(View itemView) {
            super(itemView);
            tvChatRight = itemView.findViewById(R.id.tv_chat_right);
        }
    }
    class LeftViewHolder extends RecyclerView.ViewHolder {
        TextView tvChatLeft;
        public LeftViewHolder(View itemView) {
            super(itemView);
            tvChatLeft = itemView.findViewById(R.id.tv_chat_left);
        }
    }
}
