package com.szg_tech.heartcheck.fragments.evaluation_list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.szg_tech.heartcheck.core.MVPView;
import com.szg_tech.heartcheck.core.views.ButtonWithChevron;

interface EvaluationListView extends MVPView {
    RecyclerView getRecyclerView();

    Bundle getArguments();

    ButtonWithChevron getBottomButton();
}
