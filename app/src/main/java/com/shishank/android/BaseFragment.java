package com.shishank.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.shishank.android.dialogs.LoadingDialog;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //enabling toolbar to have menu items in fragment
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }


    private LoadingDialog loadingDialog;

    protected void cancelLoadingDialog() {
        if (loadingDialog != null
                && loadingDialog.getDialog() != null
                && loadingDialog.getDialog().isShowing()) {
            loadingDialog.getDialog().dismiss();
        }
    }

    protected void showLoadingDialog(int stringResId) {
        loadingDialog = LoadingDialog.newInstance(getString(stringResId));
        loadingDialog.show(getActivity().getSupportFragmentManager(), null);
    }
}
