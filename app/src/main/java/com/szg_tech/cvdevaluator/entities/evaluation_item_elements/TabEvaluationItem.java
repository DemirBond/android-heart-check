package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

import java.util.ArrayList;

public class TabEvaluationItem extends EvaluationItem {
    private ArrayList<SectionEvaluationItem> tabSectionList;

    public TabEvaluationItem(String id, String name, ArrayList<SectionEvaluationItem> tabSectionList) {
        super(id, name, null);
        this.tabSectionList = tabSectionList;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    public ArrayList<SectionEvaluationItem> getTabSectionList() {
        return tabSectionList;
    }
}
