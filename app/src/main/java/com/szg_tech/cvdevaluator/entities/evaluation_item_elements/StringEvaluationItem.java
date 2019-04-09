package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;

public class StringEvaluationItem extends EvaluationItem {
    private String text;
    private String validationRegexp;
    private boolean isEditable = true;

    public StringEvaluationItem(String id, String name, String hint, String validationRegexp) {
        super(id, name, hint);
        this.validationRegexp = validationRegexp;
    }

    public String getText() {
        return text;
    }

    public boolean isEditable() {
        return isEditable;
    }

    protected void setEditable(boolean editable) {
        isEditable = editable;
    }

    public void setText(String text) {
        this.text = text;
        if (text != null) {
            setValid(true);
        } else {
            setValid(!isMandatory());
        }
    }

    public String getValidationRegexp() {
        return validationRegexp;
    }

    @Override
    public Object getValue() {
        return text;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof String) {
            setText((String) value);
        }
        if (value == null) {
            setText(null);
        }
    }
}
