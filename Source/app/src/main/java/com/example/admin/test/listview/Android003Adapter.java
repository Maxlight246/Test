package com.example.admin.test.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.test.R;

import java.util.ArrayList;

public class Android003Adapter extends BaseAdapter {

    ArrayList<String> data;
    Context context;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvPrefix = convertView.findViewById(R.id.tv_prefix);
            viewHolder.tvName = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // lay view tu xml
        // hien thi noi dung vao view
//        TextView tvPrerx = convertView.findViewById(R.id.tv_prefix);
//        TextView tvname = convertView.findViewById(R.id.tv_name);
        String name = data.get(position);
        viewHolder.tvName.setText(name);

        String prefix = String.valueOf(name.charAt(0));
        viewHolder.tvPrefix.setText(prefix);

        return convertView;
    }

    class ViewHolder {
        TextView tvPrefix;
        TextView tvName;

        public ViewHolder() {

        }
    }
}
