package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;

import static com.szg_tech.heartcheck.core.ConfigurationParams.*;

import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
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
            add(new BooleanEvaluationItem(PALPITATIONS, "Palpitations"));
            add(new BooleanEvaluationItem(ACTIVE_PEPTIC_ULCER_DISEASE, "Peptic ulcer disease"));
            add(new BooleanEvaluationItem(LIVER_DISEASE,"Liver disease"));
            add(new BooleanEvaluationItem(BLEED_IN_THE_PAST_3_MONTHS, "Bleeding in the past 3 months"));
            add(new BooleanEvaluationItem(TIA, "Transient ischemic attack"));
            add(new BooleanEvaluationItem(CLAUDICATION, "Claudication"));
            add(new BooleanEvaluationItem(ULCER, "Lower extremity ulceration"));
            add(new BooleanEvaluationItem(UNILATERAL_LOWER_LIMB_PAIN, "Unilateral lower limb pain"));
            add(new BooleanEvaluationItem(PREVIOUS_DVT_PE, "Previous DVT"));
            add(new BooleanEvaluationItem(CARPAL, "Carpal tunnel"));
            add(new BooleanEvaluationItem(NEUROPATHY, "Peripheral Neuropathy"));
            add(new BooleanEvaluationItem(RHEUMATIC_DISEASE, "Rheumatic disease"));
            add(new BooleanEvaluationItem(IMMUNCOMPROMISED, "Other immunocompromised state"));

            add(new BoldEvaluationItem(SOCIAL_HISTORY, "Social History") {
                {
                    setBackgroundHighlighted(true);
                }
            });
            add(new BooleanEvaluationItem(TOBACCO_USE, "Tobacco use"));
            add(new SectionCheckboxEvaluationItem(ALCOHOL, "Alcohol use", new ArrayList<EvaluationItem>() {{
                add(new BooleanEvaluationItem(HEAVY_ALCOHOL, "More than 2 drinks daily"));
            }
            }));
            add(new BoldEvaluationItem(SEC_FAMILY_HISTORY, "Family History") {
                {
                    setBackgroundHighlighted(true);
                }
            });
            add(new SectionCheckboxEvaluationItem(FAMILY_HISTORY, "Family History", new ArrayList<EvaluationItem>() {{
                add(new BooleanEvaluationItem(FAMILY_HISTORY, "First-degree relative with known premature (men aged <55 years; women <60 years) coronary or vascular disease"));
                add(new BooleanEvaluationItem(FAMILY_LDL, "First-degree relative with known LDL-C above the 95th percentile"));
                add(new BooleanEvaluationItem(FAMILY_XAN, "First-degree relative with tendinous xanthomata and/or arcus cornealis, or children aged <18 years with LDL-C above the 95th percentile"));
            }
            }));


            add(new BoldEvaluationItem(SEC_COVID, "COVID-19 EXPOSURE") {
                {
                    setBackgroundHighlighted(true);
                }
            });
            add(new BooleanEvaluationItem(TRAVEL, "Close contact within 14 days of symptom onset"));
            add(new BooleanEvaluationItem(EXPOSURE, "Travel from affected geographic areas within 14 days of symptom onset"));
        }};

    }
}
