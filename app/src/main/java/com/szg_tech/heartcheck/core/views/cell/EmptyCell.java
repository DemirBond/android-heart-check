package com.szg_tech.heartcheck.core.views.cell;

import android.content.Context;
import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class EmptyCell extends LinearLayout implements CellItem {
    private float density = getContext().getResources().getDisplayMetrics().density;

    public EmptyCell(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(Color.TRANSPARENT);
    }

    public EmptyCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(Color.TRANSPARENT);
    }

    public EmptyCell(Context context, int color) {
        super(context);
        init(color);
    }

    public void init(int color) {
        ViewGroup.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (2 * density));
        setLayoutParams(layoutParams);
        setBackgroundColor(color);
    }

    @Override
    public void setLabelText(String text) {

    }

    @Override
    public void setHintText(String text) {

    }
}
