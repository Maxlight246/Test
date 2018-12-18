package com.example.admin.test.json;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.test.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



public class DetailProductActivity extends AppCompatActivity {
     TextView tvName,tvPrice,tvDescription,tvAttributes1,tvAttributes2,tvAttributes3,tvAttributes4,tvAttributes5,tvAttributes6,
                tvAttributeValue1,tvAttributeValue2,tvAttributeValue3,tvAttributeValue4,tvAttributeValue5,tvAttributeValue6;
     RecyclerView rvProduct,rvHeader;
     ArrayList<Inventories> arrData = new ArrayList<>();
     ProductAdapter2 adapter = new ProductAdapter2();
     ArrayList<String> listImages = new ArrayList<>();
     HeaderAdapter adapter2 = new HeaderAdapter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        init();
        adapter.arrdata = arrData;
        adapter.context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false);
        rvProduct.setAdapter(adapter);
        rvProduct.setLayoutManager(linearLayoutManager);
        adapter2.arrdata = listImages;
        adapter2.context = this;
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false);
        rvHeader.setLayoutManager(linearLayoutManager1);
        rvHeader.setAdapter(adapter2);


        String strProduct = getStringFromAsset("product.json");

        try {
            JSONObject jsonProduct = new JSONObject(strProduct);
            String name = jsonProduct.getString("name");
            int price = jsonProduct.getInt("basePrice");
            String descreption = jsonProduct.getString("description");
            tvName.setText(name);
            tvPrice.setText(""+price);
            tvDescription.setText(descreption);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(strProduct);
            JSONArray jsonArray = jsonObject.getJSONArray("attributes");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Attributes attributes = new Attributes();
                attributes.attributeName = jsonObject1.getString("attributeName");
                attributes.attributeValue = jsonObject1.getString("attributeValue");
                attributes.productId = jsonObject1.getInt("productId");
                switch (i){
                    case 0:
                        tvAttributes1.setText(attributes.attributeName);
                        tvAttributeValue1.setText(attributes.attributeValue);
                        break;
                    case 1:
                        tvAttributes2.setText(attributes.attributeName);
                        tvAttributeValue2.setText(attributes.attributeValue);
                        break;
                    case 2:
                        tvAttributes3.setText(attributes.attributeName);
                        tvAttributeValue3.setText(attributes.attributeValue);
                        break;
                    case 3:
                        tvAttributes4.setText(attributes.attributeName);
                        tvAttributeValue4.setText(attributes.attributeValue);
                        break;
                    case 4:
                        tvAttributes5.setText(attributes.attributeName);
                        tvAttributeValue5.setText(attributes.attributeValue);
                        break;
                    case 5:
                        tvAttributes6.setText(attributes.attributeName);
                        tvAttributeValue6.setText(attributes.attributeValue);
                        break;
                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(strProduct);
            JSONArray jsonArray = jsonObject.getJSONArray("inventories");
            for (int i = 0; i<jsonArray.length();i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Inventories inventories = new Inventories();
                inventories.branchId = jsonObject1.getInt("branchId");
                inventories.branchName = jsonObject1.getString("branchName");
                inventories.productId = jsonObject1.getInt("productId");
                inventories.cost = jsonObject1.getInt("cost");
                inventories.onHand = jsonObject1.getInt("onHand");
                inventories.reserved = jsonObject1.getInt("reserved");
                arrData.add(inventories);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();

        try {
            JSONObject jsonObject = new JSONObject(strProduct);
            JSONArray jsonArray = jsonObject.getJSONArray("images");
            String[] arr = new String[jsonArray.length()];
            for (int i = 0; i<jsonArray.length();i++){
                arr[i] = jsonArray.getString(i);
            }
            for (int i =0;i<arr.length;i++){
                listImages.add(arr[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }


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

    void init(){
        tvName = findViewById(R.id.tv_product_name);
        tvPrice = findViewById(R.id.tv_product_price);
        tvDescription = findViewById(R.id.tv_description);
        tvAttributes1 = findViewById(R.id.tv_attributename1);
        tvAttributes2 = findViewById(R.id.tv_attributename2);
        tvAttributes3 = findViewById(R.id.tv_attributename3);
        tvAttributes4 = findViewById(R.id.tv_attributename4);
        tvAttributes5 = findViewById(R.id.tv_attributename5);
        tvAttributes6 = findViewById(R.id.tv_attributename6);
        tvAttributeValue1 = findViewById(R.id.tv_attributevalue1);
        tvAttributeValue2 = findViewById(R.id.tv_attributevalue2);
        tvAttributeValue3 = findViewById(R.id.tv_attributevalue3);
        tvAttributeValue4 = findViewById(R.id.tv_attributevalue4);
        tvAttributeValue5 = findViewById(R.id.tv_attributevalue5);
        tvAttributeValue6 = findViewById(R.id.tv_attributevalue6);
        rvProduct = findViewById(R.id.rv_product);
        rvHeader = findViewById(R.id.rv_header);
    }
}
