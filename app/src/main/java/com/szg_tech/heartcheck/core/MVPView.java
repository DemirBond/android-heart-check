package com.szg_tech.heartcheck.core;

import android.app.Activity;

public interface MVPView {
    Activity getActivity();

    Presenter createPresenter();

    void startActivity(Class<? extends Activity> activity);
}
