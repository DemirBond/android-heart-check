package com.szg_tech.heartcheck.core;

import android.content.Context;
import android.support.annotation.Nullable;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_items.About;
import com.szg_tech.heartcheck.entities.evaluation_items.Evaluation;
import com.szg_tech.heartcheck.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationDataHelper {

    // TODO Refactor this to be reusable (extract?)
    public static HashMap<String, Object> createValuesDump(ArrayList<EvaluationItem> evaluationItems) {
        HashMap<String, Object> valuesDump = new HashMap<>();
        for (EvaluationItem item : evaluationItems) {
            valuesDump.put(item.getId(), item.getValue());
        }
        return valuesDump;
    }

    public static Evaluation createHomeScreenData(Context context) {
        Evaluation evaluation = new Evaluation(context);
        HashMap<String, Object> valueHashMap = EvaluationDAO.getInstance().loadValues();
        if (!valueHashMap.isEmpty()) {
            recursiveFillSection(evaluation, valueHashMap);
        }
        return evaluation;
    }

    public static EvaluationItem fetchEvaluationItemById(String id, Context context) {
        if (id.startsWith("secabout")) {
            return fetchEvaluationItemByIdForAbout(id, context);
        }
        Evaluation evaluation = new Evaluation(context);
        return fetchItemFromEvaluation(id, evaluation);
    }

    public static EvaluationItem fetchEvaluationItemByIdForAbout(String id, Context context) {
        // TODO(khait@firestak.com): Add element for About screen
        About about = new About(context);
        ArrayList<EvaluationItem> evaluationItems = about.getEvaluationItemList();
        if (evaluationItems != null) {
            for (EvaluationItem evaluationItem : evaluationItems) {
                if (id.equals(evaluationItem.getId())) {
                    return evaluationItem;
                }
            }
        }
        return null;
    }

    public static EvaluationItem fetchItemFromEvaluation(String id, Evaluation evaluation) {
        EvaluationItem item = recursiveFetch(evaluation, id);
        // fill section with data
        if (item != null) {
            HashMap<String, Object> valueHashMap = EvaluationDAO.getInstance().loadValues();
            if (!valueHashMap.isEmpty()) {
                recursiveFillSection(item, valueHashMap);
            }
        }
        return item;
    }

    public static EvaluationItem recursiveFetch(EvaluationItem item, String id) {
        ArrayList<EvaluationItem> evaluationItems;
        if (item instanceof Evaluation) {
            evaluationItems = ((Evaluation) item).getAllEvaluation();
        } else {
            evaluationItems = item.getEvaluationItemList();
        }
        if (evaluationItems != null) {
            for (EvaluationItem evaluationItem : evaluationItems) {
                if (id.equals(evaluationItem.getId())) {
                    return evaluationItem;
                } else {
                    EvaluationItem nestedResult = recursiveFetch(evaluationItem, id);
                    if (nestedResult != null) {
                        return nestedResult;
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<SectionEvaluationItem> getNextSectionItems(@Nullable List<String> ids, Context context) {
        ArrayList<SectionEvaluationItem> items = new ArrayList<>();
        if (ids != null) {
            Evaluation evaluation = new Evaluation(context);
            for (String id : ids) {
                EvaluationItem item = fetchItemFromEvaluation(id, evaluation);
                if (item instanceof SectionEvaluationItem) {
                    SectionEvaluationItem sectionEvaluationItem = (SectionEvaluationItem) item;
                    items.add(sectionEvaluationItem);
                } else if (id.equals(ConfigurationParams.COMPUTE_EVALUATION)) {
                    // item is null, is it compute button?
                    SectionEvaluationItem computeItem = new SectionEvaluationItem(
                            context,
                            ConfigurationParams.COMPUTE_EVALUATION,
                            context.getResources().getString(R.string.compute_evaluation),
                            new ArrayList<>()
                    );
                    items.add(computeItem);
                }
            }
        }
        return items;
    }

    public static void recursiveFillSection(EvaluationItem tempEvaluationItem, Map<String, Object> valueHashMap) {
        ArrayList<EvaluationItem> evaluationItems = tempEvaluationItem.getEvaluationItemList();
        if (evaluationItems != null) {
            for (EvaluationItem evaluationItem : evaluationItems) {
                Object value = valueHashMap.get(evaluationItem.getId());
                if (value != null) {
                    evaluationItem.setValue(value);
                }
                recursiveFillSection(evaluationItem, valueHashMap);
            }
        }
    }
}
