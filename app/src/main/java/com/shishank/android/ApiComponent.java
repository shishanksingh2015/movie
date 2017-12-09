package com.shishank.android;

import com.shishank.android.api.ApiModule;
import com.shishank.android.movie.MovieListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(BaseActivity baseActivity);

    void inject(BasePresenter basePresenter);

    void inject(MovieListPresenter basePresenter);

}
