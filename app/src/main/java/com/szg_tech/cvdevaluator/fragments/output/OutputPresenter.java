package com.szg_tech.cvdevaluator.fragments.output;

import android.view.Menu;
import android.view.MenuItem;

import com.szg_tech.cvdevaluator.core.Presenter;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;

interface OutputPresenter extends Presenter {
    void onCreate();

    void onReturnToEvaluationButtonClick();

    void onSaveEvaluationButtonClick();

    void onResume();

    boolean onOptionsItemSelected(MenuItem item);

    void onPrepareOptionsMenu(Menu menu);



}
