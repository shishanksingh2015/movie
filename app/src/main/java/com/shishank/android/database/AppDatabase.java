package com.shishank.android.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.shishank.android.models.MovieData;
import com.shishank.android.dao.MovieDataDao;

/**
 * @author shishank
 */

@Database(entities = {MovieData.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieDataDao movieDataDao();
}
