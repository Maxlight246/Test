package com.example.admin.test.json;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.test.R;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends PagerAdapter {
    ArrayList<String> images;
    Context context;


    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

       View v = LayoutInflater.from(context).inflate(R.layout.item_viewpager,container,false);
        ImageView img = v.findViewById(R.id.img_product);
        img.setImageResource(Integer.parseInt(images.get(position)));
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
