package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

public class ICOCellEvaluationItem extends EvaluationItem {
    private String blueButtonText;
    private String greenButtonText;

    public ICOCellEvaluationItem(String id, String name, String hint,
                                 String blueButtonText, String greenButtonText) {
        super(id, name, hint);
        this.blueButtonText = blueButtonText;
        this.greenButtonText = greenButtonText;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    public String getBlueButtonText() {
        return blueButtonText;
    }

    public String getGreenButtonText() {
        return greenButtonText;
    }
}
