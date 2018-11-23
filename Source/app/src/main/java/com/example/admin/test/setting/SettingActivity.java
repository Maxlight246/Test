package com.example.admin.test.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.admin.test.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Switch swWifi,swBluetooth;
    CheckBox cbBatterySave;
    Button btSave;
    EditText edPhoneName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
//        btSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isWifiOn = swWifi.isChecked();
//                boolean isBluetooth = swBluetooth.isChecked();
//                boolean isBatterySave = cbBatterySave.isChecked();
//                String phoneName = edPhoneName.getText().toString();
//            }
//        });
        btSave.setOnClickListener(this);
        swWifi.setOnCheckedChangeListener(this);
        edPhoneName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    void init(){
        swWifi = findViewById(R.id.sw_wifi);
        swBluetooth = findViewById(R.id.sw_bluetooth);
        cbBatterySave = findViewById(R.id.cb_baterrysave);
        edPhoneName = findViewById(R.id.ed_phonename);
        btSave = findViewById(R.id.bt_save);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.bt_save:
                Toast.makeText(this, "allo", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id){
            case R.id.sw_wifi:
                Toast.makeText(this, "wifi is "+(swWifi.isChecked()?"on":"off"), Toast.LENGTH_SHORT).show();
        }
    }


}
