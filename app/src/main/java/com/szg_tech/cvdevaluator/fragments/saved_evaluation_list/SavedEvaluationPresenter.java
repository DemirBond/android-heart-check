package com.szg_tech.cvdevaluator.fragments.saved_evaluation_list;

import com.szg_tech.cvdevaluator.core.Presenter;
import com.szg_tech.cvdevaluator.rest.responses.SavedEvaluationItem;

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
