package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import static com.szg_tech.heartcheck.core.ConfigurationParams.*;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class InHospitalTherapies extends SectionEvaluationItem {
    InHospitalTherapies(Context context) {
        super(context, IN_HOSPITAL_THERAPIES, null);
        name = getString(R.string.in_hospital_therapies);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(FOUR_ANTIARRYTHMIC, getString(R.string.four_antiarrythmic), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVAA, getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(BOLUS_IVAA, getString(R.string.bolus)));
                        add(new BooleanEvaluationItem(TITRATION_IVAA, getString(R.string.titration)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVAA, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                        add(new BooleanEvaluationItem(TRANSITION_TO_PO_ANTIARRYTHMIC, getString(R.string.transition_to_po_antiarrythmic)));
                    }
                }));
                add(new BooleanEvaluationItem(URGENT_CV, getString(R.string.urgent_cv)));
                add(new BooleanEvaluationItem(DEFIBRILLATION_ACLS, getString(R.string.defibrillation_acls)));
                add(new SectionCheckboxEvaluationItem(FOUR_ANTIHYPERTENSIVE, getString(R.string.four_antihypertensive), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVHT, getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(BOLUS_IVHT, getString(R.string.bolus)));
                        add(new BooleanEvaluationItem(TITRATION_IVHT, getString(R.string.titration)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVHT, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(FOUR_VASOACTIVE, getString(R.string.four_vasoactive), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVVA, getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(BOLUS_IVVA, getString(R.string.bolus)));
                        add(new BooleanEvaluationItem(TITRATION_IVVA, getString(R.string.titration)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVVA, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                        add(new BooleanEvaluationItem(FOUR_NPS, getString(R.string.four_nps)));
                        add(new BooleanEvaluationItem(FOUR_NTG, getString(R.string.four_ntg)));
                        add(new BooleanEvaluationItem(FOUR_MILRINONE, getString(R.string.four_milrinone)));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(FOUR_DIURETIC, getString(R.string.four_diuretic), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVDI, getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(INTERMITTENT, getString(R.string.intermittent)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVDI, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(MECHANICAL_VENTIALLATION_OR_NIPPV, getString(R.string.mechanical_ventiallation_or_nippv), new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(RESPIRATORY_INTERVENTIONS_Q_HR, getString(R.string.respiratory_interventions_q_hr), getString(R.string.value), 1, 6, true));
                    }
                }));
                add(new NumericalEvaluationItem(O2_SUPPLEMENT, getString(R.string.o2_supplement), getString(R.string.value), 23, 100, true));
                add(new BooleanEvaluationItem(FOUR_VASOPRESSORS, getString(R.string.four_vasopressors)));
                add(new BooleanEvaluationItem(ULTRAFILTRATION, getString(R.string.ultrafiltration)));
                add(new BooleanEvaluationItem(IABP, getString(R.string.iabp)));
                add(new BooleanEvaluationItem(TEMPORARY_PM, getString(R.string.temporary_pm)));
            }
        };
    }
}
