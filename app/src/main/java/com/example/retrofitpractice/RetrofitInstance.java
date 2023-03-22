package com.example.retrofitpractice;

import static com.example.retrofitpractice.MainActivity.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
   public static RetrofitInstance instance;
    Apiinterface apiinterface;
    RetrofitInstance(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).build();
        apiinterface=retrofit.create(Apiinterface.class);
    }
    public static RetrofitInstance getInstance(){
        if(instance==null){
            instance=new RetrofitInstance();
        }
        return instance;
    }
}
