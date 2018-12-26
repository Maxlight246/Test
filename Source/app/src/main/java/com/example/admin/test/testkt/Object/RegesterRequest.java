package com.example.admin.test.testkt.Object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegesterRequest {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public User data;

}