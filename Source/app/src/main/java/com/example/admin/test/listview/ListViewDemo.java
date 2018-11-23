package com.example.admin.test.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.test.R;

import java.util.ArrayList;

public class ListViewDemo extends AppCompatActivity {
    ArrayList<String> arrayName = new ArrayList<>();
    ListView lvAndroid003;
//    ArrayAdapter<String> adapter;
    Android003Adapter adapter;
    @Override
    protected void onNewIntent(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        preareData();
        init();
//        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayName);
//        lvAndroid003.setAdapter(adapter);
        adapter = new Android003Adapter();
        adapter.data = arrayName;
        adapter.context = this;
        lvAndroid003.setAdapter(adapter);


    }
    void init(){
        lvAndroid003 = findViewById(R.id.lv_android003);
    }

    void preareData(){
        arrayName.add("a");
        arrayName.add("a1");
        arrayName.add("a2");
        arrayName.add("a3");
        arrayName.add("a4");
        arrayName.add("a5");
        arrayName.add("a6");
        arrayName.add("a7");
        arrayName.add("a8");
        arrayName.add("a");
        arrayName.add("a1");
        arrayName.add("a2");
        arrayName.add("a3");
        arrayName.add("a4");
        arrayName.add("a5");
        arrayName.add("a6");
        arrayName.add("a7");
        arrayName.add("a8");
    }
}
