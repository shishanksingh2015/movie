package com.shishank.android.dao;

import com.shishank.android.models.MovieData;

import io.reactivex.Single;
import lombok.NonNull;

/**
 * @author shishank
 */

public interface DatabaseInteractor {

    void setMovieData(MovieData data);

    Single<MovieData> getMovieData(@NonNull int id);

    void setCallbacks(DatabaseCallbacks callbacks);

}
