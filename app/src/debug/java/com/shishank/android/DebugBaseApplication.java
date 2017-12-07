package com.shishank.android;

import com.shishank.android.BaseApplication;

public class DebugBaseApplication extends BaseApplication {

    public void enableMockMode() {
        apiComponent = DaggerMockApiComponent.create();
    }
}
