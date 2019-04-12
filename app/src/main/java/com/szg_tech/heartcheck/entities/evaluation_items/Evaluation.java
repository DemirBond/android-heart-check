package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.core.ConfigurationParams;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

public class Evaluation extends SectionEvaluationItem {

    public Evaluation(Context context) {
        super(context, ConfigurationParams.EVALUATION, null);
        name = getString(R.string.evaluation);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        ArrayList<EvaluationItem> items = new ArrayList<>();
        items.add(new Bio(context));
        items.add(new Symptoms(context));
        items.add(new ReviewOfSystems(context));
        items.add(new PhysicalExam(context));

        items.add(new CurrentCVProfile(context));
        items.add(new Pulmonary(context));
        items.add(new Renal(context));
        items.add(new MajorCVRisk(context));

        items.add(new NonCardiacSurgicalRisk(context));
        items.add(new Laboratories(context));
        items.add(new Diagnostics(context));
        items.add(new Therapies(context));

        return items;
    }
}
