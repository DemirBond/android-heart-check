package com.szg_tech.heartcheck.fragments.saved_evaluation_list;

import com.szg_tech.heartcheck.core.Presenter;
import com.szg_tech.heartcheck.rest.responses.SavedEvaluationItem;

import java.util.List;

/**
 * Created by ahmetkucuk on 4/5/17.
 */

public interface SavedEvaluationPresenter extends Presenter {
    void onCreate();

    void onResume();

    void setData(List<SavedEvaluationItem> itemList);

    void setError(String error);
}
