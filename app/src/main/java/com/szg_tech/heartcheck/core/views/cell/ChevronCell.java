package com.szg_tech.heartcheck.core.views.cell;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.szg_tech.heartcheck.R;

public abstract class ChevronCell extends CellWithIndent {

    ImageView chevron;

    public ImageView getChevron() {
        return chevron;
    }


    public ChevronCell(Context context) {
        super(context);
    }

    public ChevronCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChevronCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ChevronCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView() {
        super.initView();
        chevron = findViewById(R.id.chevron_fwd);
    }

    public void showChevron(boolean visible) {
        chevron.setVisibility(visible ? VISIBLE : GONE);
    }
}
