package com.example.mobilfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apı {
    @GET("api/news.json")
    Call<List<Calisanlar>> getData();

}
