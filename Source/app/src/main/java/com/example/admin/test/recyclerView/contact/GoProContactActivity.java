package com.example.admin.test.recyclerView.contact;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admin.test.R;

import java.util.ArrayList;

public class GoProContactActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rvContact;
    FloatingActionButton fbAdd;
    CardView cvContact;
    public static ArrayList<GoProContact> arrData = new ArrayList<>();
   public static ContactAdapter adapter = new ContactAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_pro_contact);
        init();

        fbAdd.setOnClickListener(this);
        adapter.arrdata=arrData;
        adapter.context=this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayout.VERTICAL,false);
        rvContact.setLayoutManager(linearLayoutManager);
        rvContact.setAdapter(adapter);

    }
    void init(){
        rvContact = findViewById(R.id.rv_contact);
        fbAdd = findViewById(R.id.fb_add);
        cvContact = findViewById(R.id.cv_contact);
        adapter.onRecyclerViewItemClickListener = new OnRecyclerViewItemClickListener() {
            @Override
            public void OnItemClick(int pos) {
                Intent intent = new Intent(GoProContactActivity.this,AddActivity.class);
                intent.putExtra("positon",pos);
                startActivity(intent);
            }


        };
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,AddActivity.class);
        startActivityForResult(intent,999 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==999&&resultCode==RESULT_OK){
           GoProContact goProContact= (GoProContact) data.getExtras().getSerializable("contact");
           arrData.add(goProContact);
           adapter.notifyItemInserted(arrData.size()-1);
           rvContact.scrollToPosition(adapter.getItemCount()-1);
        }

    }


}
