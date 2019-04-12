package com.szg_tech.heartcheck.entities.evaluation_item_elements;

import com.szg_tech.heartcheck.entities.EvaluationItem;

public class MinutesSecondsEvaluationItem extends EvaluationItem {
    private Integer minutes;
    private Integer seconds;

    public MinutesSecondsEvaluationItem(String id) {
        super(id, null, null);
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @Override
    public Integer getValue() {
        return minutes;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Integer) {
            minutes = (Integer) value;
        }
    }
}
