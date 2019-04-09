package com.szg_tech.cvdevaluator.rest.responses;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ahmetkucuk on 4/5/17.
 */

public class SavedEvaluationSummaryResponse extends BaseResponse {

    private List<SavedEvaluationItem> evals;

    public List<SavedEvaluationItem> getEvals() {
        return evals;
    }

    public void setEvals(List<SavedEvaluationItem> evals) {
        this.evals = evals;
    }

    @Override
    public String toString() {
        return "SavedEvaluationSummaryResponse{" +
                "evals=" + evals +
                '}';
    }
}
