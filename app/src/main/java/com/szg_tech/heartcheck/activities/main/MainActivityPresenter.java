package com.szg_tech.heartcheck.activities.main;

import android.view.MenuItem;

import com.szg_tech.heartcheck.core.Presenter;

interface MainActivityPresenter extends Presenter {
    void onCreate();

    boolean onOptionsItemSelected(MenuItem item);
}
