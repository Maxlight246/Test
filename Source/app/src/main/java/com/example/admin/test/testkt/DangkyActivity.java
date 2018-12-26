package com.example.admin.test.testkt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.test.R;

public class DangkyActivity extends AppCompatActivity {
    EditText edName, edPassword, edPasswordAgain;
    Button btDangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        init();
    }

    private void init() {
        edName = findViewById(R.id.ed_name);
        edPassword = findViewById(R.id.ed_password);
        edPasswordAgain = findViewById(R.id.ed_password_again);
        btDangky = findViewById(R.id.bt_dangky);
    }
}
