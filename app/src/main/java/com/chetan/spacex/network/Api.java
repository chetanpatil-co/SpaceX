package com.chetan.spacex.network;

import com.chetan.spacex.model.Launch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.spacexdata.com/v3/";

    @GET("launches")
    Call<List<Launch>> getLaunches();
}
