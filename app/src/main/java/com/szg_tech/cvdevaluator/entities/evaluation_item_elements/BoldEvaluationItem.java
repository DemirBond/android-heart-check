package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

public class BoldEvaluationItem extends EvaluationItem {
    private boolean isBackgroundHighlighted;

    public BoldEvaluationItem(String id, String name) {
        super(id, name, null);
    }

    public boolean isBackgroundHighlighted() {
        return isBackgroundHighlighted;
    }

    protected void setBackgroundHighlighted(boolean isBackgroundHighlighted) {
        this.isBackgroundHighlighted = isBackgroundHighlighted;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object object) {
    }
}
