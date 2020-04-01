package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import static com.szg_tech.heartcheck.core.ConfigurationParams.*;

import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

/**
 * Created by davischan on 8/22/17.
 */


class Pulmonary extends SectionEvaluationItem {

    Pulmonary(Context context) {
        super(context, PULMONARY, null);
        name = "Pulmonary";
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {

                add(new BooleanEvaluationItem(HYPERCAPNIA, "Severe chronic hypercapnia"));
                add(new SectionCheckboxEvaluationItem(ASTHMA, "Reactive airway disease", new ArrayList<EvaluationItem>() {
                    {

                        add(new NumericalEvaluationItem(SYMPTOMS_WEEK, " Symptoms / week ", "Value", 0, 112, true));
                        add(new NumericalEvaluationItem(NOCTURNAL, " Nocturnal awakening / week ", "Value", 0, 112, true));
                        add(new NumericalEvaluationItem(SABA_USE, " SABA use / week ", "Value", 0, 112, true));
                        add(new SectionCheckboxEvaluationItem(INTERFERENCE, "Interference with activity", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(NONE, "None"));
                                add(new BooleanEvaluationItem(MINOR, "Minor"));
                                add(new BooleanEvaluationItem(SOME, "Some"));
                                add(new BooleanEvaluationItem(SIGNIFICANT, "Significant"));
                            }
                        }));

                    }
                }));
                add(new SectionCheckboxEvaluationItem(LUNG_COPD, "COPD", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(ACUTE_EXACERBATION, "Acute exacerbation"));
                        add(new BooleanEvaluationItem(COPDEX, "More than 1 COPD exacerbation/year "));
                        add(new BooleanEvaluationItem(COPDHOS, "One or more hospital admission/year "));
                    }
                }));
                add(new BooleanEvaluationItem(ILD, "Interstitial lung disease"));
                add(new SectionCheckboxEvaluationItem(OSA, "OSA", new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(AHI, "AHI ", "Value", 0, 112, true));
                    }
                }));
            }
        };
    }
}
