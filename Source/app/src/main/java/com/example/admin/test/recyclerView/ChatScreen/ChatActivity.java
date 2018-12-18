package com.example.admin.test.recyclerView.ChatScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.admin.test.R;

import java.util.ArrayList;
import java.util.Random;

public class ChatActivity extends AppCompatActivity {
    RecyclerView rvChat;
    Button btSend;
    EditText edContext;
    ArrayList<Message> arrData = new ArrayList<>();
    ChatAdapter adapter = new ChatAdapter();
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();

        adapter.arrdata = arrData;
        adapter.context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, true);
        rvChat.setLayoutManager(linearLayoutManager);
        rvChat.setAdapter(adapter);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random();
                arrData.add(0,new Message(edContext.getText().toString(),vitri));
                edContext.setText("");
                adapter.notifyDataSetChanged();
            }
        });

    }

    void init() {
        rvChat = findViewById(R.id.rv_chat);
        btSend = findViewById(R.id.bt_send);
        edContext = findViewById(R.id.ed_context);
    }
     void random(){
         Random r = new Random();
         vitri = r.nextInt(2);
     }

}

