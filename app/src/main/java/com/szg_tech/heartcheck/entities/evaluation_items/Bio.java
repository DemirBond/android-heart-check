package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalDependantEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.StringEvaluationItem;

import java.util.ArrayList;

import static com.szg_tech.heartcheck.core.ConfigurationParams.AGE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.BIO;
import static com.szg_tech.heartcheck.core.ConfigurationParams.BMI;
import static com.szg_tech.heartcheck.core.ConfigurationParams.DBP;
import static com.szg_tech.heartcheck.core.ConfigurationParams.DBP_OPTIONAL;
import static com.szg_tech.heartcheck.core.ConfigurationParams.FEMALE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.GENDER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.HEART_RATE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.MALE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.NAME;
import static com.szg_tech.heartcheck.core.ConfigurationParams.ORTHOSTATIC_SBP;
import static com.szg_tech.heartcheck.core.ConfigurationParams.ORTHOSTATIC_SYMPTOMPS;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PREGNANCY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RASAT;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RESP_RATE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SBP;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SBP_OPTIONAL_LOWER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SBP_OPTIONAL_UPPER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.TEMPARATURE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.WAIST_CIRC;
import static com.szg_tech.heartcheck.core.ConfigurationParams.WEIGHT;

class
Bio extends SectionEvaluationItem {

    Bio(Context context) {
        super(context, BIO, null);
        name = getString(R.string.bio);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }
    //IDs for SBP<90 : txtDurationSBP, SBP>130 :txtNumberSBP, DBP>80: txtNumberDBP
    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        ArrayList<EvaluationItem> items = new ArrayList<>();
        StringEvaluationItem nameItem = new StringEvaluationItem(NAME, getString(R.string.name), getString(R.string.name_hint), null);
        NumericalEvaluationItem ageItem = new NumericalEvaluationItem(AGE, getString(R.string.age), getString(R.string.age_hint), 20, 100, true);
        nameItem.setMandatory(true);
        ageItem.setMandatory(true);
        items.add(nameItem);
        items.add(ageItem);
        items.add(new SectionPlaceholderEvaluationItem(GENDER, getString(R.string.gender), getString(R.string.male),
                new ArrayList<EvaluationItem>() {
                    {
                        add(new RadioButtonGroupEvaluationItem(MALE, getString(R.string.male), GENDER, true));
                        add(new RadioButtonGroupEvaluationItem(FEMALE, getString(R.string.female), GENDER, false));
                    }
                }));

        NumericalEvaluationItem sbpItem = new NumericalEvaluationItem(
                SBP, getString(R.string.sbp), getString(R.string.sbp_hint), 60, 300, true);

        NumericalDependantEvaluationItem sbpOptionalLowerItem = new NumericalDependantEvaluationItem(
                SBP_OPTIONAL_LOWER,
                tempContext.getString(R.string.expanded_optional_headline),
                tempContext.getString(R.string.expanded_optional_hint),
                90,
                90,
                true,
                SBP,
                90,
                90
        );

        NumericalDependantEvaluationItem sbpOptionalUpperItem = new NumericalDependantEvaluationItem(
                SBP_OPTIONAL_UPPER,
                tempContext.getString(R.string.expanded_optional_headline),
                tempContext.getString(R.string.expanded_optional_hint),
                130,
                130,
                true,
                SBP,
                130,
                130
        );

        NumericalEvaluationItem dbpItem = new NumericalEvaluationItem(
                DBP, getString(R.string.dbp), getString(R.string.dbp_hint), 30, 160, true);

        NumericalDependantEvaluationItem dbpOptionalItem = new NumericalDependantEvaluationItem(
                DBP_OPTIONAL,
                tempContext.getString(R.string.expanded_optional_headline),
                tempContext.getString(R.string.expanded_optional_hint),
                80,
                80,
                true,
                DBP,
                80,
                80
        );

        sbpItem.setMandatory(true);
        dbpItem.setMandatory(true);

        items.add(sbpItem);
        items.add(sbpOptionalLowerItem);
        items.add(sbpOptionalUpperItem);
        items.add(dbpItem);
        items.add(dbpOptionalItem);

        items.add(new NumericalEvaluationItem(HEART_RATE, getString(R.string.heart_rate), getString(R.string.heart_rate_hint), 30, 300, true));
        items.add(new NumericalEvaluationItem(RESP_RATE, "Respiratory Rate", getString(R.string.heart_rate_hint), 10, 50, true));
        items.add(new NumericalEvaluationItem(RASAT, "RA O2 sat", "Value", 50, 100, true));
        items.add(new NumericalEvaluationItem(TEMPARATURE, "Temperature / C", getString(R.string.heart_rate_hint), 20, 300, true));
        items.add(new NumericalEvaluationItem(ORTHOSTATIC_SBP, "Orthostatic SBP", "Value", 0, 240, true));
        items.add(new BooleanEvaluationItem(ORTHOSTATIC_SYMPTOMPS, getString(R.string.orthostatic_symptomps)));
        items.add(new NumericalEvaluationItem(BMI, "BMI", "Enter BMI value", 10, 50, true));
        items.add(new NumericalEvaluationItem(WEIGHT, "Weight kg", "Enter weight value", 40, 400, true));
        items.add(new NumericalEvaluationItem(WAIST_CIRC, getString(R.string.waist_circ), getString(R.string.value), 20, 60, false));
        //items.add(new BooleanEvaluationItem(AA, getString(R.string.aa)));
        items.add(new BooleanEvaluationItem(PREGNANCY, getString(R.string.pregnancy)));

        return items;
    }
}
