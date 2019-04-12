package com.szg_tech.heartcheck.fragments.about;

import android.support.v7.widget.RecyclerView;

import com.szg_tech.heartcheck.core.MVPView;

interface AboutView extends MVPView {
    RecyclerView getRecyclerView();
}
