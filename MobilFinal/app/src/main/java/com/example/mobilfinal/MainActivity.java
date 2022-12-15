package com.example.mobilfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Calisanlar>calisanlarModel;
    private String api_url ="https://hltv-api.vercel.app/";
    Retrofit rtf;
    RecyclerView recyclerView ;
    rvAdapter rvAdapter;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rc_View)  ;
        Gson gson = new GsonBuilder().setLenient().create();
        rtf =new Retrofit.Builder()
                .baseUrl(api_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

         veriAl();
    }
    public  void veriAl(){
        Apı calisanlarApi = rtf.create(Apı.class);
        Call<List<Calisanlar>> call= calisanlarApi.getData();
        call.enqueue(new Callback<List<Calisanlar>>() {
            @Override
            public void onResponse(Call<List<Calisanlar>> call, Response<List<Calisanlar>> response) {
                if(response.isSuccessful()){
                    List<Calisanlar> responseList = response.body();
                    calisanlarModel = new ArrayList<>(responseList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvAdapter= new rvAdapter(calisanlarModel);
                    recyclerView.setAdapter(rvAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Calisanlar>> call, Throwable t) {


            }
        });


    }

}