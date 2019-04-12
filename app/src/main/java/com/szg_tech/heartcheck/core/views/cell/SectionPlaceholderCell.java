package com.szg_tech.heartcheck.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.core.views.CustomTextView;

public class SectionPlaceholderCell extends CellWithIndent implements CellItem {
    private CustomTextView textView;
    private CustomTextView placeHolderView;

    public SectionPlaceholderCell(Context context) {
        super(context);
        inflate(context);
    }

    public SectionPlaceholderCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public SectionPlaceholderCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public SectionPlaceholderCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.section_placeholder_cell, this);
        initView();
    }

    public void initView() {
        super.initView();
        textView = findViewById(R.id.name);
        placeHolderView = findViewById(R.id.placeholder);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {
        placeHolderView.setHint(text);
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

}
