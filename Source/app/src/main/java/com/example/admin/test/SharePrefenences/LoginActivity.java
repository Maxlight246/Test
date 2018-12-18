package com.example.admin.test.SharePrefenences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.test.R;
import com.example.admin.test.SharePrefenences.utill.AppConfig;
import com.example.admin.test.setting.SettingActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edName;
    Button btSave;
    CheckBox cbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login3_layout);
        init();
        checkLogin();

    }

    void init() {
        edName = findViewById(R.id.ed_name);
        btSave = findViewById(R.id.bt_save);
        cbRemember = findViewById(R.id.cb_remember);
//        btSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                // luu lai gia tri
////                SharedPreferences sharedPreferences = getSharedPreferences("android003",MODE_WORLD_WRITEABLE);
////                // cong cu chinh sua
////                SharedPreferences.Editor editor = sharedPreferences.edit();
////                editor.putString("user_name",edName.getText().toString());
////                // luu lai
////                editor.apply();
//
//            }
//        });
        // lay data tu shareprefeneces
//        SharedPreferences sharedPreferences = getSharedPreferences("android003",MODE_PRIVATE);
//        String username = sharedPreferences.getString("user_name","");
//        edName.setText(username);
        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AppConfig.setKeepLogin(isChecked, LoginActivity.this);
            }
        });
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LogoutActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    void checkLogin(){
        if (AppConfig.getKeepLogin(this)){
            Intent intent = new Intent(LoginActivity.this,LogoutActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
