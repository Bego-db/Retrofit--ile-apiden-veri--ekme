package com.example.mobilfinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Calisanlar {
    @SerializedName("title")
    @Expose
    public String calisan_ID;
    @SerializedName("description")
    @Expose
    public String calisan_Ad;

    @SerializedName("time")
    @Expose
    public String calisan_Yas;



}

