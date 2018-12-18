package com.example.admin.test.SharePrefenences;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.test.R;
import com.example.admin.test.SharePrefenences.utill.AppConfig;

public class LogoutActivity extends AppCompatActivity {

    Button btLogOut;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btLogOut = findViewById(R.id.bt_logout);
        btLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.setKeepLogin(false,LogoutActivity.this);
                Intent intent = new Intent(LogoutActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
