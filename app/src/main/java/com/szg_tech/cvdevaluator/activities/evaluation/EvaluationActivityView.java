package com.szg_tech.cvdevaluator.activities.evaluation;

import com.szg_tech.cvdevaluator.core.MVPView;
import com.szg_tech.cvdevaluator.entities.evaluation_items.HeartSpecialistManagement;

interface EvaluationActivityView extends MVPView {
    HeartSpecialistManagement getHeartSpecialistManagement();

    void onSessionExpired();
}
