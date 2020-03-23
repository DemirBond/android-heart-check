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
 * Created by davischan on 8/23/17.
 */

class Renal extends SectionEvaluationItem {

    Renal(Context context) {
        super(context, RENAL, null);
        name = "Renal";
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(WORSENING_RENAL_FX, "Acute renal failure / worsening renal function", new ArrayList<EvaluationItem>() {
                    {

                        add(new NumericalEvaluationItem(CRINC, " Increase in SCrx baseline ", "Value", 1, 10, true));
                        add(new NumericalEvaluationItem(CR48H, " Increase in SCr by mg/dl in 48hr ", "Value", 0.1, 112, true));
                        add(new NumericalEvaluationItem(URVOL, " Urine volume ml/kg/h", "Value", 0, 200, true));


                    }
                }));




                add(new SectionCheckboxEvaluationItem(CKD, "Chronic kidney disease", new ArrayList<EvaluationItem>() {
                    {
                        //add(new BooleanEvaluationItem(context, ACUTE_EXACERBATION, "Acute exacerbation", false));
                        add(new BooleanEvaluationItem(RENALIMAGE, " Abnormal renal imaging  "));
                        add(new BooleanEvaluationItem(HISTOLOGY, " Abnormal laboratory "));
                    }
                }));
            }
        };
    }
}
