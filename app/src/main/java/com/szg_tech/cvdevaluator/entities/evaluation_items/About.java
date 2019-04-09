package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.BuildConfig;
import com.szg_tech.cvdevaluator.R;

import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.StringEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.TextEvaluationItem;

import java.util.ArrayList;

public class About extends SectionEvaluationItem {
    public About(Context context) {
        super(context, ABOUT, null);
        name = context.getString(R.string.about);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(tempContext, PRIVACY_POLICY, context.getString(R.string.privacy_policy), new ArrayList<EvaluationItem>() {
                    {

                    }
                }, SectionElementState.OPENED) {
                    {
                        setHasStateIcon(false);
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(tempContext, TERMS_OF_USE, context.getString(R.string.terms_of_use), new ArrayList<EvaluationItem>() {
                    {
                        add(new TextEvaluationItem(TERMS_OF_USE_TEXT, context.getString(R.string.terms_of_use_text)));
                    }
                }, SectionElementState.OPENED) {
                    {
                        setHasStateIcon(false);
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(tempContext, HELP_SUPPORT, context.getString(R.string.help_support), new ArrayList<EvaluationItem>() {
                    {

                    }
                }, SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                        setHasStateIcon(false);
                    }
                });
                add(new BoldEvaluationItem(DEVELOPMENT, context.getString(R.string.development)));
                add(new StringEvaluationItem(LOGIC, context.getString(R.string.logic), null, null) {
                    {
                        setText(context.getString(R.string.logic_dev_name));
                        setEditable(false);
                    }
                });
                add(new StringEvaluationItem(ENGINEERING, context.getString(R.string.engineering), null, null) {
                    {
                        setText(context.getString(R.string.engineering_dev_name));
                        setEditable(false);
                    }
                });
                add(new StringEvaluationItem(DESIGN, context.getString(R.string.design), null, null) {
                    {
                        setText(context.getString(R.string.designer_name));
                        setEditable(false);
                    }
                });
                add(new BoldEvaluationItem(VERSION_CAPS, context.getString(R.string.version_caps)));
                add(new TextEvaluationItem(VERSION, String.format(context.getString(R.string.version), BuildConfig.VERSION_NAME)));
            }
        };
    }
}
