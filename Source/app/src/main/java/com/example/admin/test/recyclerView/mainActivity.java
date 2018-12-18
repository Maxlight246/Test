package com.example.admin.test.recyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.test.Danhsachsinhvien.Sinhvien;
import com.example.admin.test.R;

import java.util.ArrayList;

public class mainActivity extends AppCompatActivity {
    RecyclerView rvSinhvien;
    ArrayList<Sinhvien> arrData = new ArrayList<>();
    RecycleViewAdapter adapter = new RecycleViewAdapter();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
        prearedata();
        // can them LayoutManager
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        rvSinhvien.setLayoutManager(gridLayoutManager);
        //
        adapter.data=arrData;
        adapter.context = this;
        rvSinhvien.setAdapter(adapter);

    }

     void init() {
        rvSinhvien = findViewById(R.id.rv_student);
    }
    void prearedata(){
        for (int i=0;i<10;i++){
         Sinhvien sinhvien = new Sinhvien("sv"+i,"sv_diachi"+i,22);
         arrData.add(sinhvien);
        }
    }
}
