package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;

import static com.szg_tech.heartcheck.core.ConfigurationParams.*;

import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class ReviewOfSystems extends SectionEvaluationItem {
    ReviewOfSystems(Context context) {
        super(context, REVIEW_OF_SYSTEMS, null);
        name = context.getString(R.string.review_of_systems);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {{
            add(new BooleanEvaluationItem(WEIGHT_CHANGE, "Weight gain"));
            add(new BooleanEvaluationItem(THYROTOXICOSIS, "Thyrotoxicosis"));
            add(new BooleanEvaluationItem(HYPOTHYRO, "Hypothyroidism"));
            add(new BooleanEvaluationItem(OSA, "Obstructive sleep apnea"));
            add(new BooleanEvaluationItem(SINUS, "Sinusitis"));
            add(new BooleanEvaluationItem(COUGH, "Cough"));
            add(new BooleanEvaluationItem(SPUTUM, "Sputum"));
            add(new BooleanEvaluationItem(HEMOPTYSIS, "Hemoptysis"));
            add(new BooleanEvaluationItem(PREVIOUS_DVTE, "Previous pulmonary embolism"));
            add(new BooleanEvaluationItem(PND, "Paroxysmal nocturnal dyspnea"));
            add(new BooleanEvaluationItem(ORTHOPNEA, "Orthopnea"));
            add(new BooleanEvaluationItem(PALPITATIONS, getString(R.string.palpitations)));
            add(new BooleanEvaluationItem(ACTIVE_PEPTIC_ULCER_DISEASE, getString(R.string.active_peptic_ulcer_disease)));
            add(new BooleanEvaluationItem(LIVER_DISEASE, getString(R.string.liver_disease)));
            add(new BooleanEvaluationItem(BLEED_IN_THE_PAST_3_MONTHS, "Bleeding in the past 3 months"));
            add(new BooleanEvaluationItem(TIA, "Transient ischemic attack"));
            add(new BooleanEvaluationItem(CLAUDICATION, "Claudication"));
            add(new BooleanEvaluationItem(ULCER, "Lower extremity ulceration"));
            add(new BooleanEvaluationItem(UNILATERAL_LOWER_LIMB_PAIN, "Unilateral lower limb pain"));
            add(new BooleanEvaluationItem(PREVIOUS_DVT_PE, "Previous DVT"));
            add(new BooleanEvaluationItem(RHEUMATIC_DISEASE, "Rheumatic disease"));
        }};
    }
}
