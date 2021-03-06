package com.szg_tech.heartcheck.core.views.cell;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.view.View;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.core.views.CustomTextView;

public class TextCell extends CellWithIndent implements CellItem {
    private CustomTextView textView;

    public TextCell(Context context) {
        super(context);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.text_cell, this);
        initView();
    }

    public void initView() {
        super.initView();
        textView = findViewById(R.id.text);
        setUpView();
    }

    private void setUpView() {

    }

    public void setTextColor(int color) {
        textView.setTextColor(color);
    }

    public void showDot() {
        findViewById(R.id.txtDot).setVisibility(View.VISIBLE);
    }

    @Override
    public void setHintText(String text) {

    }

    @Override
    public void setLabelText(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(text));
        }
        Linkify.addLinks(textView, Linkify.ALL);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}