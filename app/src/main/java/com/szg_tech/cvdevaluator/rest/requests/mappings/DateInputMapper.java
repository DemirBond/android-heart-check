package com.szg_tech.cvdevaluator.rest.requests.mappings;

import android.util.Pair;

import com.szg_tech.cvdevaluator.core.ConfigurationParams;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ahmetkucuk on 4/4/17.
 */

public class DateInputMapper {

    public static void mapOnSetOfHeartFailure(Map<String, Object> evaluationValueMap) {

        if(evaluationValueMap.containsKey(ConfigurationParams.ON_SET_OF_HEART_FAILURE)) {
            Object value = evaluationValueMap.get(ConfigurationParams.ON_SET_OF_HEART_FAILURE);
            if(value instanceof Long) {
                Date date = new Date((Long)value);
                String month = new SimpleDateFormat("MM")
                        .format(date);
                String year = new SimpleDateFormat("yyyy")
                        .format(date);

                evaluationValueMap.put(ConfigurationParams.ON_SET_HEART_FAILURE_MONTH, month);
                evaluationValueMap.put(ConfigurationParams.ON_SET_HEART_FAILURE_YEAR, year);

            } else {
                System.err.println("Parameter " + ConfigurationParams.ON_SET_OF_HEART_FAILURE + " is expected to be long. But it is not");
            }
            evaluationValueMap.remove(ConfigurationParams.ON_SET_OF_HEART_FAILURE);
        }
    }

}
