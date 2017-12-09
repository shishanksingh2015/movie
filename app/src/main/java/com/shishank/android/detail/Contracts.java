package com.shishank.android.detail;

import com.shishank.android.models.MovieData;

/**
 * @author shishank
 */

public interface Contracts {

    interface View {
        void initView();

        void PopulateData();

        void onCompleted(MovieData movieData);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void init();

        void updateMovie(MovieData movieData);

        void findMovie(int id);
    }
}
