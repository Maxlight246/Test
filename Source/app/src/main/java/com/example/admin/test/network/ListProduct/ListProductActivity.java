package com.example.admin.test.network.ListProduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.admin.test.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListProductActivity extends AppCompatActivity {
    RecyclerView rvListProduct;
    List<Product> arrData = new ArrayList<>();
    ListProductAdapter adapter = new ListProductAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        init();
        adapter.arrdata= arrData;
        adapter.context = this;
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL );
        rvListProduct.setAdapter(adapter);
        rvListProduct.setLayoutManager(staggeredGridLayoutManager);

    }

    private void init() {

        rvListProduct = findViewById(R.id.rv_list_product);

        // get file Json
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.json-generator.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(APIServices.class).login().enqueue(new Callback<ListRequest>() {
            @Override
            public void onResponse(Call<ListRequest> call, Response<ListRequest> response) {
                if (response.isSuccessful()){
                    ListRequest listRequest = response.body();
                    if (listRequest.status==1){

                        for (int i = 0; i< listRequest.getData().size();i++){
                            Product product = new Product();
                            product.setName(listRequest.getData().get(i).getName());
                            product.setBasePrice(listRequest.getData().get(i).getBasePrice());
                            product.setImage(listRequest.getData().get(i).getImage());
                            arrData.add(product);
                        }
                        adapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<ListRequest> call, Throwable t) {

            }
        });
    }





}
