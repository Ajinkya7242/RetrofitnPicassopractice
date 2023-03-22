package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public  static String api="https://jsonplaceholder.typicode.com ";
   List<userModel> alluserList;
   RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiinterface.getUsers().enqueue(new Callback<List<userModel>>() {
            @Override
            public void onResponse(Call<List<userModel>> call, Response<List<userModel>> response) {
                Log.e("apiget","OnFailure:"+response.body().toString());
                alluserList=response.body();
                recyclerView.setAdapter(new userAdapter(MainActivity.this,alluserList));
                for(int i=0;i<alluserList.size();i++){
                    Log.e("apiget","OnFailure:"+alluserList.get(i).title);
                }
            }

            @Override
            public void onFailure(Call<List<userModel>> call, Throwable t) {
                Log.e("api","OnFailure:"+t.getLocalizedMessage());
            }
        });


    }
}