package com.szg_tech.heartcheck.core.views.cell;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.szg_tech.heartcheck.R;

public class CellWithIndent extends LinearLayout {

    TextView levelMark;

    public CellWithIndent(Context context) {
        super(context);
    }

    public CellWithIndent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CellWithIndent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CellWithIndent(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setLevelMark(int level, boolean isLeaf){

        int counter = level;
        StringBuilder levelValue = new StringBuilder();
        while(counter!=0){
            counter--;
            levelValue.append(" ‧ ");
        }
        levelMark.setText(levelValue.toString());
    }

    public void initView(){
        levelMark = findViewById(R.id.level_mark);
    }
}
