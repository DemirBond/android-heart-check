package com.szg_tech.heartcheck.activities.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.activities.authentication.AuthenticationActivity;
import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.ConfigurableFragment;
import com.szg_tech.heartcheck.core.ConfigurationParams;
import com.szg_tech.heartcheck.fragments.evaluation_list.EvaluationListFragment;
import com.szg_tech.heartcheck.storage.PreferenceHelper;

import static com.szg_tech.heartcheck.core.ConfigurationParams.NEXT_SECTION_ABOUT;

class MainActivityPresenterImpl extends AbstractPresenter<MainActivityView> implements MainActivityPresenter {
    MainActivityPresenterImpl(MainActivityView view) {
        super(view);
    }

    @Override
    public void onCreate() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConfigurableFragment fragment = null;
        String backStackName = null;
        Activity activity = getActivity();
        switch (item.getItemId()) {
            case R.id.about:
                fragment = new EvaluationListFragment();
                Bundle bundle = new Bundle();
                if (activity != null) {
                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, NEXT_SECTION_ABOUT);
                    showActionBar((AppCompatActivity) activity, true);
                }
                fragment.setArguments(bundle);
                backStackName = EvaluationListFragment.class.getSimpleName();
                break;
            case R.id.sign:
                item.setTitle(getActivity().getResources().getString(R.string.sign_out));

                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                PreferenceHelper.removeCredentials(getActivity());
                Intent intent = new Intent(getActivity(), AuthenticationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
                getActivity().finish();
                return true;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && fragment != null) {
            int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
            if (backStackEntryCount < 1 || !fragment.getClass().getSimpleName().equals(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName())) {
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(backStackName).commit();
                return true;
            }
        }
        return false;
    }

    private void showActionBar(AppCompatActivity activity, boolean isShow) {
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(isShow);
            }
        }
    }
}
