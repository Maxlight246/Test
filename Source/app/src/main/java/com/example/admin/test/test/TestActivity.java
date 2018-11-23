package com.example.admin.test.test;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.test.R;

public class TestActivity extends AppCompatActivity {
     EditText ed1,ed2,ed3,ed4,ed5,ed6;
     Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        init();

        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed1.getText().toString().length()==1){
                    ed2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed2.getText().toString().length()==1){
                    ed3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed3.getText().toString().length()==1){
                    ed4.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed4.getText().toString().length()==1){
                    ed5.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed5.getText().toString().length()==1){
                    ed6.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        ed6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (s.length()==1){
//                    Toast.makeText(TestActivity.this, "tinh tinh", Toast.LENGTH_SHORT).show();
//                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    void init(){
        ed1 = findViewById(R.id.ed_1);
        ed2 = findViewById(R.id.ed_2);
        ed3 = findViewById(R.id.ed_3);
        ed4 = findViewById(R.id.ed_4);
        ed5 = findViewById(R.id.ed_5);
        ed6 = findViewById(R.id.ed_6);
        bt1 = findViewById(R.id.bt_confrim);
    }

    public void confirm(View view) {
        check();
    }

    void check(){
      if (ed1.getText().toString().isEmpty()||ed2.getText().toString().isEmpty()||ed3.getText().toString().isEmpty()||
              ed4.getText().toString().isEmpty()||ed5.getText().toString().isEmpty()||ed6.getText().toString().isEmpty()){
          MediaPlayer mp = MediaPlayer.create(this,R.raw.fail);
          mp.start();
          Toast.makeText(this, "you're noob shit, feeder, pinoy, chingchong, wtf, @#$%^7*", Toast.LENGTH_SHORT).show();
      }else {
          MediaPlayer mp1 = MediaPlayer.create(this,R.raw.ting);
          mp1.start();
          Toast.makeText(this, "you're godlike, rampage, ggwp, wp, ez game", Toast.LENGTH_SHORT).show();

      }


    }
}
