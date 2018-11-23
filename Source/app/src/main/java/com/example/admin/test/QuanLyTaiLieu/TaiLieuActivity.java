package com.example.admin.test.QuanLyTaiLieu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.test.R;

public class TaiLieuActivity extends AppCompatActivity {
    EditText edID,edProducer,edCount;
    Button bt1;
    TextView tv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tailieu_layout);
        init();

    }
    void init(){
        edID = findViewById(R.id.ed_Ma);
        edProducer = findViewById(R.id.ed_nhaXuatBan);
        edCount = findViewById(R.id.ed_soBanphathanh);
        bt1 = findViewById(R.id.bt_save);
        tv1 = findViewById(R.id.tv_Tittle);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaiLieu taiLieu = new TaiLieu();
                taiLieu.maTaiLieu= edID.getText().toString();
                taiLieu.nhaXuatBan= edProducer.getText().toString();
                taiLieu.soBanPhatHanh= Integer.parseInt(edCount.getText().toString());
            }
        });
    }
}
