package com.shishank.android.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.shishank.android.models.MovieData;

import io.reactivex.Single;

/**
 * @author shishank
 */

@Dao
public interface MovieDataDao {

    @Query("SELECT * FROM MovieData WHERE id = :id")
    Single<MovieData> getMovieData(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMovieData(MovieData movieData);

    @Update
    void updateMovieData(MovieData movieData);

}
