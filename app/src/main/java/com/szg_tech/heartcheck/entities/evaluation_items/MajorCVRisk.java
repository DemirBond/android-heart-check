package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import static com.szg_tech.heartcheck.core.ConfigurationParams.*;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class MajorCVRisk extends SectionEvaluationItem {
    MajorCVRisk(Context context) {
        super(context, MAJOR_CV_RISK, null);
        name = "Diabetes";
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(DIABETES, getString(R.string.diabetes), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionCheckboxEvaluationItem(TYPE_2_DM, getString(R.string.type_2_dm), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(DMNP, "Diabetic Nephropathy"));
                                add(new BooleanEvaluationItem(DMCKD, "Diabetic CKD"));
                                add(new BooleanEvaluationItem(DMOTHER,"Other kidney complications"));
                                add(new BooleanEvaluationItem(DMMONO, "Diabetic mononeuropathy"));
                                add(new BooleanEvaluationItem(DMPOLY, "Diabetic polyneuropathy"));
                                add(new BooleanEvaluationItem(DMAUTONOM, "Diabetic autonom neuropathy"));
                                add(new BooleanEvaluationItem(DMANGIO, "Peripheral angiopathy"));
                                add(new BooleanEvaluationItem(DMOTHERCIRC, "Other circulatory complications"));
                                add(new BooleanEvaluationItem(DMGANGRENE, "Angiopathy with gangrene"));
                                add(new BooleanEvaluationItem(DMARTHRO, "Diabetic arthropathy"));
                                add(new BooleanEvaluationItem(DMSKIN, "Diabetic skin complications"));
                                add(new BooleanEvaluationItem(DMORAL, "Diabetic oral complications"));
                                add(new BooleanEvaluationItem(DMHYPO, "Hypoglycemia"));
                                add(new BooleanEvaluationItem(DMHYPOCOMA, "Hypoglycemia with coma"));
                                add(new BooleanEvaluationItem(DMHYPER, "Hyperglycemia"));
                                add(new BooleanEvaluationItem(DMOTHERCOMP, "Other specified complications"));
                                add(new BooleanEvaluationItem(DMUNSPEC, "Unspecified complications"));

                                add(new BooleanEvaluationItem(DMWITHOUT, " Without complications"));
                            }
                        }));


                        add(new SectionCheckboxEvaluationItem(TYPE_1_DM, getString(R.string.type_1_dm), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(DMNP, "Diabetic Nephropathy"));
                                add(new BooleanEvaluationItem(DMCKD, "Diabetic CKD"));
                                add(new BooleanEvaluationItem(DMCKD,"Other kidney complications"));
                                add(new BooleanEvaluationItem(DMMONO, "Diabetic mononeuropathy"));
                                add(new BooleanEvaluationItem(DMPOLY, "Diabetic polyneuropathy"));
                                add(new BooleanEvaluationItem(DMAUTONOM, "Diabetic autonom neuropathy"));
                                add(new BooleanEvaluationItem(DMANGIO, "Peripheral angiopathy"));
                                add(new BooleanEvaluationItem(DMOTHERCIRC, "Other circulatory complications"));
                                add(new BooleanEvaluationItem(DMGANGRENE, "Angiopathy with gangrene"));
                                add(new BooleanEvaluationItem(DMARTHRO, "Diabetic arthropathy"));
                                add(new BooleanEvaluationItem(DMSKIN, "Diabetic skin complications"));
                                add(new BooleanEvaluationItem(DMORAL, "Diabetic oral complications"));
                                add(new BooleanEvaluationItem(DMHYPO, "Hypoglycemia"));
                                add(new BooleanEvaluationItem(DMHYPOCOMA, "Hypoglycemia with coma"));
                                add(new BooleanEvaluationItem(DMHYPER, "Hyperglycemia"));
                                add(new BooleanEvaluationItem(DMOTHERCOMP, "Other specified complications"));
                                add(new BooleanEvaluationItem(DMUNSPEC, "Unspecified complications"));

                                add(new BooleanEvaluationItem(DMWITHOUT, " Without complications"));

                            }
                        }));
                        add(new BooleanEvaluationItem(GESTATIONAL_DM, getString(R.string.gestational_dm)));
                        add(new BooleanEvaluationItem(RETINOPATHY, getString(R.string.retinopathy)));
                    }
                }));

                add(new BooleanEvaluationItem(TOBACCO_USE, getString(R.string.tobacco_use)));
                add(new BooleanEvaluationItem(FAMILY_HISTORY, getString(R.string.family_history)));

            }
        };
    }
}
