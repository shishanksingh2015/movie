package com.shishank.android;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.shishank.android.dao.DatabaseInteractor;
import com.shishank.android.dao.DatabaseWrapper;
import com.shishank.android.database.AppDatabase;

import lombok.Getter;
import timber.log.Timber;

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Getter
    protected ApiComponent apiComponent;

    @Getter
    private DatabaseInteractor databaseInteractor;

    @Getter
    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        apiComponent = DaggerApiComponent.create();
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "movieData").build();
        databaseInteractor = new DatabaseWrapper();
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
