package com.shishank.android;

import com.shishank.android.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(BaseActivity baseActivity);

    void inject(BasePresenter basePresenter);

}
