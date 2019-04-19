package com.szg_tech.heartcheck.fragments.tab_fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.szg_tech.heartcheck.core.MVPView;
import com.szg_tech.heartcheck.core.views.ButtonWithChevron;

interface TabFragmentView extends MVPView {
    TabLayout getTabLayout();

    Bundle getArguments();

    ViewPager getViewPager();

    FragmentManager getChildFragmentManager();

    ButtonWithChevron getBottomButton();
}
