package com.example.admin.test.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIServices {
    // khai bao cac API su dung
    // kieu request
    // duong dan api
    // kieu du lieu tra ve
    // ten api
    // kieu du lieu truyen vao

    @GET("users/login")
    Call<LoginRequest> login(@Query("username")String username , @Query("password")String password);

    @POST("service/RegisterService.svc/GetListRestaurantType")
    Call<String> GetList();

}
