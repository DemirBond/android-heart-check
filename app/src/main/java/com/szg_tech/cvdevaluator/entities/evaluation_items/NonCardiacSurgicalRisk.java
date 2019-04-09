package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class NonCardiacSurgicalRisk extends SectionEvaluationItem {
    NonCardiacSurgicalRisk(Context context) {
        super(context, NONCARDIAC_SURGICAL_RISK, null);
        name = getString(R.string.noncardiac_surgical_risk);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BooleanEvaluationItem(EMERGENCY_SURGERY, getString(R.string.emergency_surgery)));
                add(new BooleanEvaluationItem(INTERMEDIATE_RISK, getString(R.string.intermediate_risk)));
                add(new BooleanEvaluationItem(HIGH_RISK, getString(R.string.high_risk)));
                add(new BooleanEvaluationItem(LOW_RISK_SURGERY_CATARACT_PLASTIC, getString(R.string.low_risk_surgery_cataract_plastic)));
                add(new BooleanEvaluationItem(UNABLE_TO_EXERCISE_PHYSICALLY_INACTIVE, getString(R.string.unable_to_exercise_physically_inactive)));
                add(new NumericalEvaluationItem(METS, getString(R.string.mets), getString(R.string.value), 0, 21, true));
                add(new NumericalEvaluationItem(DUKE_ACTIVITY_SCORE_INDEX, "Duke Activity Status Index", getString(R.string.value), 0, 99, true));
            }
        };
    }
}
