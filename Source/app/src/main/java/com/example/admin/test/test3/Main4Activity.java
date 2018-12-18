package com.example.admin.test.test3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.test.R;
import com.example.admin.test.json.Attributes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Main4Activity extends AppCompatActivity {
    TextView tvName, tvName2, tvName3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();

    String strProduct = getStringFromAsset("product.json");
        try {
            JSONObject jsonObject = new JSONObject(strProduct);
            String name = jsonObject.getString("name");
            tvName.setText(name);
            JSONArray jsonArray = jsonObject.getJSONArray("attributes");
            JSONObject jsonObject1 = jsonArray.getJSONObject(1);
            Attributes attributes = new Attributes();
            attributes.setAttributeName(jsonObject1.getString("attributeName"));
            attributes.setAttributeValue(jsonObject1.getString("attributeValue"));
            attributes.setProductId(jsonObject1.getInt("productId"));
            tvName2.setText(attributes.getAttributeName());
            tvName3.setText(attributes.getAttributeValue());

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void init() {
       tvName = findViewById(R.id.tv_name);
       tvName2 = findViewById(R.id.tv_name2);
       tvName3 = findViewById(R.id.tv_name3);
    }
    // doc file ngoai
    private String getStringFromAsset(String fileName){
        String text = "";
        try{
            InputStream inputStream = getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
