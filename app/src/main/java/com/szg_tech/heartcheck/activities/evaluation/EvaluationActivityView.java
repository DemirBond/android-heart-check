package com.szg_tech.heartcheck.activities.evaluation;

import android.view.View;

import com.szg_tech.heartcheck.core.MVPView;
import com.szg_tech.heartcheck.entities.evaluation_items.HeartSpecialistManagement;

interface EvaluationActivityView extends MVPView {
    HeartSpecialistManagement getHeartSpecialistManagement();

    void onSessionExpired();

    View getLayout();
}
