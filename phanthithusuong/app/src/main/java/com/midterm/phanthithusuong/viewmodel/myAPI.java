package com.midterm.phanthithusuong.viewmodel;

import com.midterm.phanthithusuong.model.mymodel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface myAPI {
    @GET("b/62503b89d8a4cc06909df432")
    public Single<List<mymodel>> getAPI();

}
