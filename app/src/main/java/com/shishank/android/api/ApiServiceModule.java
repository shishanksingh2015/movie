package com.shishank.android.api;

import com.shishank.android.models.response.DiscoverResponse;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author shishank
 */

public class ApiServiceModule implements ApiService {
    @Override
    public Observable<DiscoverResponse> getMoviesList(Map<String, Object> params) {
        return ApiModule.getApiService().getMoviesList(params);
    }
}
