package com.example.admin.test.json;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder2> {

    @Override
    public Viewholder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Viewholder2 holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Viewholder2 extends RecyclerView.ViewHolder {
        public Viewholder2(View itemView) {
            super(itemView);
        }
    }
}
