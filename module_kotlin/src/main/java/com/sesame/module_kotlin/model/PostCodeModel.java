package com.sesame.module_kotlin.model;

import com.google.gson.annotations.SerializedName;


public class PostCodeModel {

    @SerializedName("PostNumber")
    public String postNumber;
    @SerializedName("Province")
    public String province;
    @SerializedName("City")
    public String city;
    @SerializedName("District")
    public String district;
    @SerializedName("Address")
    public String address;

}
