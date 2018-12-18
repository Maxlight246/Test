package com.example.admin.test.recyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.admin.test.Danhsachsinhvien.Sinhvien;
import com.example.admin.test.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    RecyclerView rvMulType;
    ArrayList<Object> arrData = new ArrayList<>();
    MutiTypeAdapter adapter = new MutiTypeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        preareData();
        adapter.arrdata=arrData;
        adapter.context=this;
        rvMulType.setAdapter(adapter);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this,LinearLayout.VERTICAL,false);
        rvMulType.setLayoutManager(linearLayout);

    }
    void init (){
        rvMulType= findViewById(R.id.rv_multype);
    }
    void preareData() {
        arrData.add("20/11/2017");
        for (int i = 0; i < 10; i++) {
            Sinhvien sinhvien = new Sinhvien("sv" + i, "sv_diachi" + i, 22);
            arrData.add(sinhvien);
        }
        arrData.add("20/12/2017");
        for (int i = 0; i < 10; i++) {
            Sinhvien sinhvien = new Sinhvien("sv" + i, "sv_diachi" + i, 22);
            arrData.add(sinhvien);
        }
        arrData.add("20/14/2017");
        for (int i = 0; i < 10; i++) {
            Sinhvien sinhvien = new Sinhvien("sv" + i, "sv_diachi" + i, 22);
            arrData.add(sinhvien);
        }
        arrData.add("20/15/2017");
        for (int i = 0; i < 10; i++) {
            Sinhvien sinhvien = new Sinhvien("sv" + i, "sv_diachi" + i, 22);
            arrData.add(sinhvien);
        }
    }

}
