package com.szg_tech.heartcheck.entities.evaluation_item_elements;

import com.szg_tech.heartcheck.entities.EvaluationItem;

import java.util.ArrayList;

public class RadioButtonGroupEvaluationItem extends EvaluationItem {
    private String groupName;
    private boolean isChecked;
    private boolean isBackgroundHighlighted;
    private ArrayList<EvaluationItem> evaluationItemList;

    public RadioButtonGroupEvaluationItem(String id, String name, String groupName, boolean isChecked) {
        this(id, name, groupName, isChecked, null);
    }

    protected RadioButtonGroupEvaluationItem(String id, String name, String groupName, boolean isChecked, ArrayList<EvaluationItem> evaluationItemList) {
        super(id, name, null);
        this.groupName = groupName;
        this.isChecked = isChecked;
        this.evaluationItemList = evaluationItemList;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return evaluationItemList;
    }

    @Override
    public Object getValue() {
        return isChecked;
    }

    @Override
    public void setValue(Object value) {
        isChecked = (Boolean) value;
    }

    public boolean isBackgroundHighlighted() {
        return isBackgroundHighlighted;
    }

    protected void setBackgroundHighlighted(boolean backgroundHighlighted) {
        isBackgroundHighlighted = backgroundHighlighted;
    }
}
