package com.szg_tech.heartcheck.fragments.tab_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.ConfigurationParams;
import com.szg_tech.heartcheck.core.EvaluationDataHelper;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.TabEvaluationItem;
import com.szg_tech.heartcheck.fragments.evaluation_list.EvaluationListFragment;
import com.szg_tech.heartcheck.fragments.output.OutputFragment;

import java.util.ArrayList;
import java.util.List;

class TabFragmentPresenterImpl extends AbstractPresenter<TabFragmentView> implements TabFragmentPresenter {
    private List<SectionEvaluationItem> tabSectionList;
    private ArrayList<SectionEvaluationItem> nextSectionEvaluationItemArrayList;

    TabFragmentPresenterImpl(TabFragmentView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        TabLayout tabLayout = getView().getTabLayout();
        ViewPager viewPager = getView().getViewPager();
        Bundle arguments = getView().getArguments();
        if (arguments != null) {
            // TODO Extract data from
            String tabSectionId = arguments.getString(ConfigurationParams.TAB_SECTION_LIST);


            EvaluationItem item = EvaluationDataHelper.fetchEvaluationItemById(tabSectionId,getActivity());
            if(item!=null){
                tabSectionList = ((TabEvaluationItem)item).getTabSectionList();
            }

            ArrayList<String> sectionIds = arguments.getStringArrayList(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS);
            nextSectionEvaluationItemArrayList = EvaluationDataHelper.getNextSectionItems(sectionIds, getActivity());

            if (tabSectionList != null) {
                TabFragmentPresenterAdapter tabFragmentPresenterAdapter = new TabFragmentPresenterAdapter(getView().getChildFragmentManager());
                viewPager.setAdapter(tabFragmentPresenterAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
            if ((nextSectionEvaluationItemArrayList != null && nextSectionEvaluationItemArrayList.size() >= 1)) {
                getView().getBottomButton().setText(nextSectionEvaluationItemArrayList.get(0).getName());
            } else {
                getView().getBottomButton().setVisibility(View.GONE);
            }
        }
    }

    private class TabFragmentPresenterAdapter extends FragmentStatePagerAdapter {
        TabFragmentPresenterAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new EvaluationListFragment();
            Bundle args = new Bundle();
            // TODO Extract bundle data to id
            args.putSerializable(ConfigurationParams.NEXT_SECTION_ID, tabSectionList.get(position).getId());
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return tabSectionList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Activity activity = getActivity();
            String pageTitle = null;
            if (activity != null) {
                pageTitle = activity.getString(R.string.page) + (position + 1);
            }
            return pageTitle;
        }
        @Override
        public Parcelable saveState()
        {
            Bundle bundle = (Bundle) super.saveState();
            if (bundle != null)
            {
                // Never maintain any states from the base class, just null it out
                bundle.putParcelableArray("states", null);
            } else
            {
                // do nothing
            }
            return bundle;
        }
    }

    @Override
    public void onBottomButtonClick() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            Bundle bundle = new Bundle();
            ArrayList<String> nextSectionIds = new ArrayList<>();
            for(SectionEvaluationItem item : nextSectionEvaluationItemArrayList){
                nextSectionIds.add(item.getId());
            }
            bundle.putStringArrayList(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, nextSectionIds);
            if (nextSectionEvaluationItemArrayList.size() >= 1
                    && nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().size() == 1
                    && nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0) instanceof TabEvaluationItem
                ) {
                TabFragment tabFragment = new TabFragment();
                bundle.putString(ConfigurationParams.TAB_SECTION_LIST, (nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0)).getId());
                tabFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.container, tabFragment)
                        .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItemArrayList.get(0).getName())
                        .commit();
                if (nextSectionEvaluationItemArrayList.get(0).getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                    nextSectionEvaluationItemArrayList.get(0).setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                }
            } else if (nextSectionEvaluationItemArrayList.size() >= 1) {
                Fragment nextFragment = new EvaluationListFragment();
                SectionEvaluationItem nextSectionEvaluationItem = nextSectionEvaluationItemArrayList.get(0);
                if (ConfigurationParams.COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId())) {
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, new OutputFragment())
                            .addToBackStack(OutputFragment.class.getSimpleName())
                            .commit();
                } else {
                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, nextSectionEvaluationItem.getId());
                    nextFragment.setArguments(bundle);
                    if (nextSectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED) {
                        nextSectionEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                    }
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, nextFragment)
                            .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItem.getName())
                            .commit();
                }
            }
        }
    }
}
