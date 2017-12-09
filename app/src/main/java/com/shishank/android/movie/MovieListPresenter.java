package com.shishank.android.movie;

import com.shishank.android.BasePresenter;
import com.shishank.android.Constants;
import com.shishank.android.models.response.DiscoverResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @author shishank
 */

public class MovieListPresenter extends BasePresenter implements Contracts.Presenter {


    private Contracts.View movieView;
    private boolean isUpdating;
    private Map<String, Object> queryMap;

    public MovieListPresenter(Contracts.View movieView) {
        super();
        this.movieView = movieView;
        queryMap = new HashMap<>();
        queryMap.put("api_key", Constants.API_KEY);
    }

    @Override
    public void init() {
        movieView.initView();
    }

    @Override
    public void fetchMovies(int pageIndex) {
        queryMap.put("page", pageIndex);
        fetchMovieList(queryMap);
    }

    private void fetchMovieList(Map<String, Object> map) {
        isUpdating = true;
        apiService.getMoviesList(map).observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> isUpdating = false)
                .map(DiscoverResponse::getResults)
                .subscribe(movieView::populateData, movieView::onError);
    }

    @Override
    public boolean shouldUpdate() {
        return !isUpdating;
    }

    @Override
    public void sortByPopularity(int pageIndex) {
        movieView.sortingList();
        queryMap.put("sort_by", "popularity.desc");
        queryMap.put("page", pageIndex);
        fetchMovieList(queryMap);
    }

    @Override
    public void sortByRating(int pageIndex) {
        movieView.sortingList();
        queryMap.put("sort_by", "vote_average.desc");
        queryMap.put("page", pageIndex);
        fetchMovieList(queryMap);
    }

    @Override
    public void showLoading() {
        movieView.showLoading();
    }

    @Override
    public void hideLoading() {
        movieView.hideLoading();
    }
}
