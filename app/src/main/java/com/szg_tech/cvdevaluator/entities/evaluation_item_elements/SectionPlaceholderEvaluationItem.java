package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

import java.util.ArrayList;

public class SectionPlaceholderEvaluationItem extends EvaluationItem {
    private ArrayList<EvaluationItem> evaluationItemList;

    public SectionPlaceholderEvaluationItem(String id, String name, String hint, ArrayList<EvaluationItem> evaluationItemList) {
        super(id, name, hint);
        this.evaluationItemList = evaluationItemList;
    }

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return evaluationItemList;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }
}
