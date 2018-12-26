package com.example.admin.test.testkt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.admin.test.R;
import com.example.admin.test.testkt.Object.ListRequest;
import com.example.admin.test.testkt.Object.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {
    RecyclerView rvProduct;
    ArrayList<Product> arrData = new ArrayList<>();
    ProductAdapter3 adapter = new ProductAdapter3();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
        Data();
        adapter.arrdata = arrData;
        adapter.context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayout.VERTICAL,false);
        rvProduct.setAdapter(adapter);
        rvProduct.setLayoutManager(linearLayoutManager);

    }

    private void Data() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.12:3000").addConverterFactory(GsonConverterFactory.create()).build();
        retrofit.create(APIServices2.class).list().enqueue(new Callback<ListRequest>() {
            @Override
            public void onResponse(Call<ListRequest> call, Response<ListRequest> response) {
                ListRequest listRequest = response.body();
                if (listRequest.getStatus()==1){
                    for (int i =0; i<listRequest.getData().size();i++){
                        Product product = new Product();
                        product.setName(listRequest.getData().get(i).getName());
                        product.setId(listRequest.getData().get(i).getId());
                        product.setPrice(listRequest.getData().get(i).getPrice());
                        product.setImages(listRequest.getData().get(i).getImages());
                        arrData.add(product);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ListRequest> call, Throwable t) {

            }
        });
    }

    private void init() {
        rvProduct = findViewById(R.id.rv_product);
    }
}
