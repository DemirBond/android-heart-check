package com.szg_tech.cvdevaluator.entities;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class EvaluationItem implements Serializable {

    private static final long serialVersionUID = -3955786975000540567L;

    protected String name;
    protected String id;
    private String hint;
    private boolean isMandatory;
    private boolean isValid = true;
    private String type;

    protected EvaluationItem(String id, String name, String hint) {
        this.name = name;
        this.id = id;
        this.hint = hint;
        type = getClass().getSimpleName();
        isMandatory = false;
    }

    public String getType(){
        return type;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
        setValid(!mandatory);
    }

    public String getName() {
        return name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getId() {
        return id;
    }

    public boolean isValid() {
        return isValid;
    }

    protected void setValid(boolean valid) {
        isValid = valid;
    }

    public abstract Object getValue();

    public abstract void setValue(Object value);

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return null;
    }
}
