package com.example.admin.test.network.ListProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIServices {

    //khai bao kieu request
    // duong dan API
    @GET("api/json/get/bUximwyGXm?indent=2")
    // kieu du lieu tra ve
    // dat ten API
    // kieu du lieu truyen vao
    Call<ListRequest> login();
}
