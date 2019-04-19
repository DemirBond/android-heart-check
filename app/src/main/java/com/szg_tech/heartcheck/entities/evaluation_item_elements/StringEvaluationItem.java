package com.szg_tech.heartcheck.entities.evaluation_item_elements;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.szg_tech.heartcheck.entities.EvaluationItem;

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

    public static class DoneOnEditorActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
            return false;
        }
    }
}
