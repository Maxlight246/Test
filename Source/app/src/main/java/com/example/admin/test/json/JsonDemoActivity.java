package com.example.admin.test.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonDemoActivity extends AppCompatActivity {

    RecyclerView rvProduct;
    ArrayList<Product> arrData = new ArrayList<>();
    ProductAdapter adapter = new ProductAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_demo);
        init();
        adapter.arrdata = arrData;
        adapter.context = this;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvProduct.setAdapter(adapter);
        rvProduct.setLayoutManager(gridLayoutManager);

        String strListProduct = getStringFromAsset("list_product.json");
        // tao json tu string
        try {
            JSONObject jsonListProduct = new JSONObject(strListProduct);
            // lam viec voi json
            JSONArray jsonArray = jsonListProduct.getJSONArray("data");
            for (int i = 0; i<jsonArray.length();i++){
               JSONObject jsonObject = jsonArray.getJSONObject(i);
               Product product = new Product();
               product.code = jsonObject.getInt("code");
               product.weight = jsonObject.getInt("weight");
               product.basePrice = jsonObject.getInt("basePrice");
               product.conversionValue = jsonObject.getInt("conversionValue");
               product.id = jsonObject.getInt("id");
               product.categoryName = jsonObject.getString("categoryName");
               product.image = jsonObject.getString("image");
               product.createdDate = jsonObject.getString("createdDate");
               product.name = jsonObject.getString("name");
               arrData.add(product);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();

    }
    // lay file tu asset ra
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
    void  init(){
        rvProduct = findViewById(R.id.rv_product);
    }
}
