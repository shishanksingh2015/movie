package com.shishank.android;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

public abstract class BaseToolBarActivity extends BaseActivity {

    private FrameLayout contentFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(com.shishank.android.R.layout.activity_base_toolbar);

        Toolbar toolbar = (Toolbar) findViewById(com.shishank.android.R.id.toolbar);
        setSupportActionBar(toolbar);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contentFrame = (FrameLayout) findViewById(com.shishank.android.R.id.activity_content);
    }

    @Override
    public void setContentView(int layoutResId) {
        getLayoutInflater().inflate(layoutResId, contentFrame, true);
    }
}
