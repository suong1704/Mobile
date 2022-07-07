package com.example.dogapp.ViewModel;

import com.example.dogapp.Model.DogBreed;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface DogAPI {
    @GET("DevTides/DogsApi/master/dogs.json")
    public Single<List<DogBreed>> getDogs();
}
