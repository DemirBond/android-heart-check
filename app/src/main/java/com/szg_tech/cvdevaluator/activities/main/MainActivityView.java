package com.szg_tech.cvdevaluator.activities.main;

import com.szg_tech.cvdevaluator.core.MVPView;

interface MainActivityView extends MVPView {
    OnAuthorizationChangedListener getOnAuthorizationChangedListener();
}
