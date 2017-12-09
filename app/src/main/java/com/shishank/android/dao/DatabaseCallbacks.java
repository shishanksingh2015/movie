package com.shishank.android.dao;

import com.shishank.android.models.MovieData;

/**
 * @author shishank
 */

public interface DatabaseCallbacks {

    void onDataInserted(MovieData data);

    void onFailed(Throwable throwable);
}
