package com.shishank.android;

import com.shishank.android.api.ApiService;

import javax.inject.Inject;

/**
 * @author shishank
 */

public class BasePresenter {

    @Inject
    protected ApiService apiService;

    protected BasePresenter() {
        BaseApplication.getInstance().getApiComponent().inject(this);
    }
}
