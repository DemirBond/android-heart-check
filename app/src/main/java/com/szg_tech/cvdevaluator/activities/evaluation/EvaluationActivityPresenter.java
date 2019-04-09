package com.szg_tech.cvdevaluator.activities.evaluation;

import android.view.MenuItem;

import com.szg_tech.cvdevaluator.core.Presenter;

interface EvaluationActivityPresenter extends Presenter {
    void onCreate();

    void createHomeScreen(boolean isAdd);

    boolean onOptionsItemSelected(MenuItem item);
}
