package com.szg_tech.heartcheck.fragments.output;

import android.view.Menu;
import android.view.MenuItem;

import com.szg_tech.heartcheck.core.Presenter;

interface OutputPresenter extends Presenter {
    void onCreate();

    void onReturnToEvaluationButtonClick();

    void onSaveEvaluationButtonClick();

    void onResume();

    boolean onOptionsItemSelected(MenuItem item);

    void onPrepareOptionsMenu(Menu menu);



}
