package com.szg_tech.heartcheck.fragments.about;

import androidx.recyclerview.widget.RecyclerView;

import com.szg_tech.heartcheck.core.MVPView;

interface AboutView extends MVPView {
    RecyclerView getRecyclerView();
}
