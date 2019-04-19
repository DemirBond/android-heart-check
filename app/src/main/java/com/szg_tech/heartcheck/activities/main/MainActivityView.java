package com.szg_tech.heartcheck.activities.main;

import com.szg_tech.heartcheck.core.MVPView;

interface MainActivityView extends MVPView {
    OnAuthorizationChangedListener getOnAuthorizationChangedListener();
}
