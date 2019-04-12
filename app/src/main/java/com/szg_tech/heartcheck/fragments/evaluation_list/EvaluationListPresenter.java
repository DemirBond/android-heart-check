package com.szg_tech.heartcheck.fragments.evaluation_list;

import android.view.MenuItem;

import com.szg_tech.heartcheck.core.Presenter;

interface EvaluationListPresenter extends Presenter {
    void onCreate();

    boolean isAboutScreen();

    boolean isEvaluationScreen();

    void onBottomButtonClick();

    void onResume();

    boolean onOptionsItemSelected(MenuItem item);

    void onPause();
}
