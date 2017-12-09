package com.shishank.android.api;

import com.shishank.android.models.response.DiscoverResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("discover/movie")
    Observable<DiscoverResponse> getMoviesList(@QueryMap Map<String, Object> params);
}
