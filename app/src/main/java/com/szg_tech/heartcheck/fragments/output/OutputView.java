package com.szg_tech.heartcheck.fragments.output;

import android.support.v7.widget.RecyclerView;

import com.szg_tech.heartcheck.core.MVPView;

interface OutputView extends MVPView {
    RecyclerView getRecyclerView();

}
