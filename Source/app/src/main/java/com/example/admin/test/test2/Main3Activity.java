package com.example.admin.test.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.admin.test.Danhsachsinhvien.Sinhvien;
import com.example.admin.test.R;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    RecyclerView rvChat;
    Button btSend;
    EditText edContext;
    ArrayList<Sinhvien> arrData = new ArrayList<>();
    Adapter adapter = new Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        adapter.arrdata=arrData;
        adapter.context=this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayout.VERTICAL,true);
        rvChat.setAdapter(adapter);
        rvChat.setLayoutManager(linearLayoutManager);
        arrData.add(0,new Sinhvien(edContext.getText().toString(),"abc",33));
        adapter.notifyDataSetChanged();
    }
    void init(){
        rvChat = findViewById(R.id.rv_chat);
        btSend = findViewById(R.id.bt_send);
        edContext = findViewById(R.id.ed_context);
    }
}
