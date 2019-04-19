package com.szg_tech.heartcheck.fragments.saved_evaluation_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.szg_tech.heartcheck.core.MVPView;

/**
 * Created by ahmetkucuk on 4/5/17.
 */

public interface SavedEvaluationView extends MVPView {
    RecyclerView getRecyclerView();

    View getNoDataView();
}
