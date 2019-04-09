package com.szg_tech.cvdevaluator.activities.main;

import android.view.MenuItem;

import com.szg_tech.cvdevaluator.core.Presenter;

interface MainActivityPresenter extends Presenter {
    void onCreate();

    boolean onOptionsItemSelected(MenuItem item);
}
