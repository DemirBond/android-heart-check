package com.szg_tech.heartcheck.activities.evaluation;

import android.view.MenuItem;

import com.szg_tech.heartcheck.core.Presenter;

interface EvaluationActivityPresenter extends Presenter {
    void onCreate();

    void createHomeScreen(boolean isAdd);

    boolean onOptionsItemSelected(MenuItem item);
}
