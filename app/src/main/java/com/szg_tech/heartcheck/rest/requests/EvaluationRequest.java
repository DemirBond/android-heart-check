package com.szg_tech.heartcheck.rest.requests;

import com.szg_tech.heartcheck.core.ConfigurationParams;
import com.szg_tech.heartcheck.rest.requests.mappings.DateInputMapper;
import com.szg_tech.heartcheck.rest.requests.mappings.RadioButtonMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmetkucuk on 3/18/17.
 */

public class EvaluationRequest {

    private String name;
    private int age;
    private int gender = 1;
    private int SBP;
    private int DBP;
    private boolean isPAH;
    private boolean forHF = false;
    private String inputs;
    private boolean isSave;
    private int evaluationID = -1;


    public EvaluationRequest(String name, int age, int gender, int SBP, int DBP, boolean isPAH, String inputs) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.SBP = SBP;
        this.DBP = DBP;
        this.isPAH = isPAH;
        this.inputs = inputs;
    }

    public EvaluationRequest(HashMap<String, Object> evaluationValueMap, boolean isSave) {
        this.isSave = isSave;
        setVariablesFromMap(evaluationValueMap);
    }

    /**
     * This method create "inputs" value for server
     * It apply some arranged rules.
     * E.g. Boolean values only appears
     * E.g. Male mapped to 1 Female mapped to 2
     * <p>
     * <p>
     * Since we cannot enforce changes in server side
     * we need to live this these boilerplate codes.
     * <p>
     * TODO add more checks or ask for improvement on server side
     */
    private void setVariablesFromMap(Map<String, Object> evaluationValueMap) {

        age = getIntVal(evaluationValueMap.get(ConfigurationParams.AGE));

        RadioButtonMapper.genderMapper().map(evaluationValueMap);
        RadioButtonMapper.anginaIndexMapper().map(evaluationValueMap);
        DateInputMapper.mapOnSetOfHeartFailure(evaluationValueMap);

        if (evaluationValueMap.containsKey(ConfigurationParams.MALE)) {
            boolean isMale = (boolean) evaluationValueMap.get(ConfigurationParams.MALE);
            gender = isMale ? 1 : 2;
        } else {
            gender = 1;
        }
        //if (evaluationValueMap.containsKey(ConfigurationParams.EVALUATION_ID))
        //    evaluationID = (Integer) evaluationValueMap.get(ConfigurationParams.EVALUATION_ID);
        name = (String) evaluationValueMap.get(ConfigurationParams.NAME);
        gender = (int) evaluationValueMap.get(ConfigurationParams.GENDER);
        SBP = getIntVal(evaluationValueMap.get(ConfigurationParams.SBP));
        DBP = getIntVal(evaluationValueMap.get(ConfigurationParams.DBP));
        isPAH = getBoolVal(evaluationValueMap.get(ConfigurationParams.IS_PAH));

        evaluationValueMap.remove(ConfigurationParams.NAME);
        evaluationValueMap.remove(ConfigurationParams.AGE);
        evaluationValueMap.remove(ConfigurationParams.SBP);
        evaluationValueMap.remove(ConfigurationParams.DBP);
        evaluationValueMap.remove(ConfigurationParams.GENDER);
        evaluationValueMap.remove(ConfigurationParams.IS_PAH);


        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : evaluationValueMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            //TODO why is this coming null, Check
            if (key == null || key.length() < 2 || (key.length() > 3 && key.substring(0, 3).equalsIgnoreCase("sec")))
                continue;
            if (value == null) continue;

            if (key.length() > 3 && key.substring(0, 3).equalsIgnoreCase("chk")) {
                if (value instanceof Boolean && ((boolean) value)) {
                    builder.append(key);
                    builder.append('|');
                } else {
                    //TODO What to do if value is not boolean but it is a chk?
                }
            } else {
                builder.append(entry.getKey()).append('=').append(entry.getValue());
                builder.append('|');
            }
        }
        if (builder.length() != 0 && builder.charAt(builder.length() - 1) == '|') {
            builder.deleteCharAt(builder.length() - 1);
        }
        inputs = builder.toString();
        if (inputs.isEmpty()) inputs = "empty";
    }

    private int getIntVal(Object o) {
        if (o instanceof Double) {
            return ((Double) o).intValue();
        } else {
            System.err.println("Evaluation Request - getIntVal [there is a serious problem with Data Storage]: " + o);
        }
        return -1;
    }

    private boolean getBoolVal(Object o) {
        if (o instanceof Boolean) {
            return ((Boolean) o);
        } else {
            System.err.println("Evaluation Request - getIntVal [there is a serious problem with Data Storage]: " + o);
        }
        return false;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (isSave) {
            map.put("name", name);
            map.put("evaluationID", evaluationID);
        }
        map.put("age", age);
        map.put("gender", gender);
        map.put("SBP", SBP);
        map.put("DBP", DBP);
        map.put("forHF", forHF);
        map.put("isPAH", isPAH);
        map.put("inputs", inputs);
        return map;
    }
}
