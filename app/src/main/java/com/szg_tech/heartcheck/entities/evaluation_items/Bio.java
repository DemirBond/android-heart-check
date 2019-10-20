package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import static com.szg_tech.heartcheck.core.ConfigurationParams.*;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.StringEvaluationItem;

import java.util.ArrayList;

class
Bio extends SectionEvaluationItem {

    Bio(Context context) {
        super(context, BIO, null);
        name = getString(R.string.bio);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

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
        NumericalEvaluationItem sbpItem = new NumericalEvaluationItem(SBP, getString(R.string.sbp), getString(R.string.sbp_hint), 60, 300, true);
        NumericalEvaluationItem dbpItem = new NumericalEvaluationItem(DBP, getString(R.string.dbp), getString(R.string.dbp_hint), 30, 160, true);


        sbpItem.setMandatory(true);
        dbpItem.setMandatory(true);
        items.add(sbpItem);
        items.add(dbpItem);
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
