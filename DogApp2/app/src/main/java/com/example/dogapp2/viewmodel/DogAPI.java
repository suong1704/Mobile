package com.example.dogapp2.viewmodel;

import com.example.dogapp2.model.DogBreed;

import java.util.List;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface DogAPI {
    @GET("DevTides/DogsApi/master/dogs.json")
    public Single<List<DogBreed>> getDogs();
}
