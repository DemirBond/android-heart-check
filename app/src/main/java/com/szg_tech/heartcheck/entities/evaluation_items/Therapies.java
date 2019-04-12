package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

import static com.szg_tech.heartcheck.core.ConfigurationParams.*;

public class Therapies extends SectionEvaluationItem {

    Therapies(Context context) {
        super(context, CURRENT_THERAPIES, context.getString(R.string.current_therapies));
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        dependsOn = BIO;

    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new POMeds(tempContext));
                add(new InHospitalTherapies(tempContext));
            }
        };
    }
}
