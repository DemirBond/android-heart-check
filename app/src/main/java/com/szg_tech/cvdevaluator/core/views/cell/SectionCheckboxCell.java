package com.szg_tech.cvdevaluator.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.views.CustomTextView;

public class SectionCheckboxCell extends ChevronCell implements CellItem {
    private CustomTextView textView;
    private CheckBox checkBox;




    public SectionCheckboxCell(Context context) {
        super(context);
        inflate(context);
    }

    public SectionCheckboxCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public SectionCheckboxCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public SectionCheckboxCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.section_checkbox_cell, this);
        initView();
    }

    public void initView() {
        super.initView();
        textView = findViewById(R.id.name);
        checkBox = findViewById(R.id.checkbox);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public boolean isChecked() {
        return checkBox.isChecked();
    }

    public void setChecked(boolean isChecked) {
        checkBox.setChecked(isChecked);
    }
}