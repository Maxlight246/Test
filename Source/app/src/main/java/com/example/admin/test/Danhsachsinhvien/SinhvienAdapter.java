package com.example.admin.test.Danhsachsinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.test.R;

import java.util.List;

public class SinhvienAdapter extends BaseAdapter {

    Context context;
    // de truyen layout vao listview
    List<Sinhvien> arrSinhvien;      // tao list kieu sinh vien


    @Override
    public int getCount() {
        return arrSinhvien.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dssv_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTen = convertView.findViewById(R.id.tv_ten);
            viewHolder.tvTuoi = convertView.findViewById(R.id.tv_tuoi);
            viewHolder.tvDiachi = convertView.findViewById(R.id.tv_diachi);
            viewHolder.tvStt = convertView.findViewById(R.id.tv_stt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // hien thi noi dung vao view
        Sinhvien sinhvien = arrSinhvien.get(position);
        viewHolder.tvTen.setText(sinhvien.getTen());
        viewHolder.tvTuoi.setText(Integer.toString(sinhvien.getTuoi()));
        viewHolder.tvDiachi.setText(sinhvien.getDiachi());
        viewHolder.tvStt.setText(Integer.toString(position));
        return convertView;
    }

    class ViewHolder {
        TextView tvTen;
        TextView tvTuoi;
        TextView tvDiachi;
        TextView tvStt;

        public ViewHolder() {

        }
    }
}
