package com.shishank.android.detail;

import com.shishank.android.BaseApplication;
import com.shishank.android.BasePresenter;
import com.shishank.android.dao.DatabaseCallbacks;
import com.shishank.android.dao.DatabaseInteractor;
import com.shishank.android.models.MovieData;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * @author shishank
 */

public class MovieDetailPresenter extends BasePresenter implements Contracts.Presenter, DatabaseCallbacks {

    private Contracts.View movieDetailView;
    private int id;
    private DatabaseInteractor databaseInteractor;

    public MovieDetailPresenter(Contracts.View movieDetailView) {
        this.movieDetailView = movieDetailView;
        databaseInteractor = BaseApplication.getInstance().getDatabaseInteractor();
        databaseInteractor.setCallbacks(this);

    }

    @Override
    public void init() {
        movieDetailView.PopulateData();
    }

    @Override
    public void updateMovie(MovieData movieData) {
        movieDetailView.showLoading();
        databaseInteractor.setMovieData(movieData);
    }

    @Override
    public void findMovie(int id) {
        databaseInteractor.getMovieData(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(movieDetailView::onCompleted, this::onFailed);
    }

    @Override
    public void onDataInserted(MovieData data) {
        findMovie(data.getId());
    }


    @Override
    public void onFailed(Throwable throwable) {
        Timber.d("data inserted"+throwable.getCause());
    }
}
