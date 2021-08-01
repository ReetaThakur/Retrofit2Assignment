package com.example.retrofit2assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/news")
    Call<List<DataModel>> getPath(@Query("category") String cat);
}
