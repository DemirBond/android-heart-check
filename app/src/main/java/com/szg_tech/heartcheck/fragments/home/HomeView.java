package com.szg_tech.heartcheck.fragments.home;

import android.support.v7.widget.RecyclerView;

import com.szg_tech.heartcheck.core.MVPView;

interface HomeView extends MVPView {
    RecyclerView getRecyclerView();
}
