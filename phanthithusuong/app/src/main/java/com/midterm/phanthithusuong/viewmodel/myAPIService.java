package com.midterm.phanthithusuong.viewmodel;

import com.midterm.phanthithusuong.model.mymodel;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class myAPIService {
    private static final  String BASE_URL = "https://api.jsonbin.io";
    private  myAPI api;
    public myAPIService(){
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(myAPI.class);
    }
    public Single<List<mymodel>> getAPI(){
        return api.getAPI();
    }
}

