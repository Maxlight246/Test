package com.example.admin.test.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantType {

    @SerializedName("SortOrder")
    @Expose
    public Integer sortOrder;
    @SerializedName("RestaurantType")
    @Expose
    public Integer restaurantType;
    @SerializedName("RestaurantTypeName")
    @Expose
    public String restaurantTypeName;
    @SerializedName("RestaurantTypeID")
    @Expose
    public String restaurantTypeID;
    @SerializedName("Description")
    @Expose
    public String description;

}
