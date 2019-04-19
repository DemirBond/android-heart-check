package com.szg_tech.heartcheck.entities.evaluation_item_elements;

import com.szg_tech.heartcheck.entities.EvaluationItem;

public class EmptyCellEvaluationItem extends EvaluationItem {

    public int getDepth() {
        return depth;
    }

    int depth;

    public EmptyCellEvaluationItem() {
        super(null, null, null);
        depth = 0;
    }

    public EmptyCellEvaluationItem(int depth) {
        super(null, null, null);
        this.depth = depth;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }
}
