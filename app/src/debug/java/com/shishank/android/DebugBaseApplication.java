package com.shishank.android;


public class DebugBaseApplication extends BaseApplication {

    public void enableMockMode() {
        apiComponent = DaggerMockApiComponent.create();
    }

    @Override
    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
