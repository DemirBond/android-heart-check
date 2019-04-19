package com.szg_tech.heartcheck.entities.evaluation_item_elements;

import com.szg_tech.heartcheck.entities.EvaluationItem;

public class TextEvaluationItem extends EvaluationItem {
    public TextEvaluationItem(String id, String name) {
        super(id, name, null);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object object) {
    }
}
