package com.example.admin.test.network;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantTypeRequest{

    @SerializedName("ErrorType")
    @Expose
    public Integer errorType;
    @SerializedName("Data")
    @Expose
    public List<RestaurantType> data = null;
    @SerializedName("Success")
    @Expose
    public Boolean success;

}