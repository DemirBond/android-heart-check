package com.szg_tech.heartcheck.entities.evaluation_item_elements;

import com.szg_tech.heartcheck.entities.EvaluationItem;

public class DatePickerEvaluationItem extends EvaluationItem {
    private Long date;

    public DatePickerEvaluationItem(String id, String name) {
        super(id, name, null);
    }

    @Override
    public Long getValue() {
        return date;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Long) {
            date = (Long) value;
        }
    }

    public Long getDate() {
        return date;
    }
}
