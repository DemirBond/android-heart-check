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
        name = getString(R.string.cv_risk);
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
                add(new SectionCheckboxEvaluationItem(SYSTEMIC_ARTERIAL_HYPERTENSION, getString(R.string.systemic_arterial_hypertension), new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(AMB_SBP, getString(R.string.amb_sbp), getString(R.string.value), 80, 190, true));
                        add(new NumericalEvaluationItem(AMB_DBP, getString(R.string.amb_dbp), getString(R.string.value), 30, 150, true));
                        add(new BoldEvaluationItem(CHECK_LVH_ON_EKG, getString(R.string.check_lvh_on_ekg)) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(SBP_TREATED, getString(R.string.sbp_treated)));
                        add(new BooleanEvaluationItem(AFRICAN_AMERICAN, getString(R.string.african_american)));
                        add(new BoldEvaluationItem(SECONDARY_HYPERTENSION, "Secondary hypertension") {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PRIMARY_HYPERALDESTERONISM, getString(R.string.primary_hyperaldesteronism)));
                        add(new BooleanEvaluationItem(RENOVASCULAR_ATHEROSCLEROTIC, getString(R.string.renovascular_atherosclerotic)));
                        add(new BooleanEvaluationItem(PHEOCROMOCYTOMA, getString(R.string.pheocromocytoma)));
                        add(new BooleanEvaluationItem(OSA, getString(R.string.osa)));
                        add(new BoldEvaluationItem(ACUTELY_SYMPTOMATIC, getString(R.string.acutely_symptomatic)) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(HEADACHED_BLURRED_VISION_OR_AMS, getString(R.string.headached_blurred_vision_or_ams)));
                        add(new BooleanEvaluationItem(EPISTAXIS, getString(R.string.epistaxis)));
                        add(new BooleanEvaluationItem(CHEST_BACK_PAIN_DYSPNEA, getString(R.string.chest_back_pain_dyspnea)));
                    }
                }));
                add(new BooleanEvaluationItem(TOBACCO_USE, getString(R.string.tobacco_use)));
                add(new BooleanEvaluationItem(FAMILY_HISTORY, getString(R.string.family_history)));

            }
        };
    }
}
