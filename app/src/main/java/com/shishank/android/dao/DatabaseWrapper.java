package com.shishank.android.dao;

import android.os.AsyncTask;

import com.shishank.android.BaseApplication;
import com.shishank.android.models.MovieData;

import io.reactivex.Single;

/**
 * @author shishank
 */

public class DatabaseWrapper implements DatabaseInteractor {

    private DatabaseCallbacks callbacks;
    private MovieDataDao movieDataDao;

    public DatabaseWrapper() {
        movieDataDao = BaseApplication.getInstance().getAppDatabase().movieDataDao();
    }

    @Override
    public void setMovieData(MovieData data) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                movieDataDao.addMovieData(data);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                callbacks.onDataInserted(data);
            }
        }.execute();

    }

    @Override
    public Single<MovieData> getMovieData(int id) {
        return movieDataDao.getMovieData(id);
    }

    @Override
    public void setCallbacks(DatabaseCallbacks callbacks) {
        this.callbacks = callbacks;
    }

}
