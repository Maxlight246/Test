package com.example.admin.test.recyclerView.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.test.R;

import java.io.Serializable;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edName, edAge, edAddr;
    Button btAdd, btSave, btDelete;
    int Vitri;
    int s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btAdd.setOnClickListener(this);
        btSave.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btSave.setVisibility(View.GONE);
        btDelete.setVisibility(View.GONE);
        if (getIntent().getExtras() != null) {
            // dang sua hoac xoa
            Intent i = getIntent();
            int vitri = i.getIntExtra("positon",s);
            Vitri=vitri;
            GoProContact goProContact = ContactAdapter.arrdata.get(Vitri);
            edName.setText(goProContact.getName());
            edAge.setText(Integer.toString(goProContact.getAge()));
            edAddr.setText(goProContact.getAddr());
            btAdd.setVisibility(View.GONE);
            btSave.setVisibility(View.VISIBLE);
            btDelete.setVisibility(View.VISIBLE);

        }


    }

    void init() {
        edName = findViewById(R.id.ed_name);
        edAge = findViewById(R.id.ed_age);
        edAddr = findViewById(R.id.ed_addr);
        btAdd = findViewById(R.id.bt_add);
        btSave = findViewById(R.id.bt_save);
        btDelete = findViewById(R.id.bt_delete_contact);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.bt_add:
                if (edAge.getText().toString().isEmpty()) {
                    Toast.makeText(this, "nhap tuoi vao", Toast.LENGTH_SHORT).show();
                } else {
                    GoProContact goProContact = new GoProContact(edName.getText().toString(),
                            edAddr.getText().toString(),
                            Integer.parseInt(edAge.getText().toString()));
                    Intent intent = new Intent();
                    intent.putExtra("contact", goProContact);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
            case R.id.bt_save:
               GoProContact goProContact = ContactAdapter.arrdata.get(Vitri);
               goProContact.setName(edName.getText().toString());
               goProContact.setAddr(edAddr.getText().toString());
               goProContact.setAge(Integer.parseInt(edAge.getText().toString()));
               GoProContactActivity.adapter.notifyDataSetChanged();
               finish();
                break;
            case R.id.bt_delete_contact:
                ContactAdapter.arrdata.remove(Vitri);
                GoProContactActivity.adapter.notifyDataSetChanged();
                finish();
                break;


        }

    }


}
