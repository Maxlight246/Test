package com.example.admin.test.testkt;

import com.example.admin.test.testkt.Object.ListRequest;
import com.example.admin.test.testkt.Object.LoginRequest2;
import com.example.admin.test.testkt.Object.RegesterRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIServices2 {
    @GET("users/login")
    Call<LoginRequest2> login (@Query("user_name")String username, @Query("password")String password);
    @GET("users/products")
    Call<ListRequest> list ();
    @POST("users/registe")
    Call<RegesterRequest> regester (@Query("user_name")String username, @Query("password")String password);
}
