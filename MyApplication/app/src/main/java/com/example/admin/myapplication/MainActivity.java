package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button bt1;
    TextView tvtitle,tvtitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.edten);
        ed2 = findViewById(R.id.edtuoi);
        ed3 = findViewById(R.id.eddiachi);
        bt1 = findViewById(R.id.save);
        tvtitle = findViewById(R.id.tvtitle);
        tvtitle1 = findViewById(R.id.tvtitle1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten1 = ed1.getText().toString();
                String diachi1 = ed3.getText().toString();
                int tuoi1 = Integer.parseInt(ed2.getText().toString());
                Sinhvien sv = new Sinhvien(ten1,diachi1,tuoi1);
                tvtitle1.setText(sv.ten+ " " +sv.tuoi+ " " +sv.diachi);
            }
        });
    }
}
