package com.szg_tech.heartcheck.activities.evaluation;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.FragmentManager;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.ConfigurationParams;
import com.szg_tech.heartcheck.core.views.modal.AlertModalManager;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.fragments.evaluation_list.EvaluationListFragment;
import com.szg_tech.heartcheck.rest.api.RestClient;
import com.szg_tech.heartcheck.rest.requests.EvaluationRequest;
import com.szg_tech.heartcheck.rest.responses.EvaluationResponse;
import com.szg_tech.heartcheck.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.szg_tech.heartcheck.core.ConfigurationParams.NEXT_SECTION_HOME_SCREEN;

class EvaluationActivityPresenterImpl extends AbstractPresenter<EvaluationActivityView> implements EvaluationActivityPresenter {

    EvaluationActivityPresenterImpl(EvaluationActivityView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        createHomeScreen(true);
        Activity activity = getActivity();
        if (activity != null) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public void createHomeScreen(boolean isAdd) {
        Activity activity = getActivity();
        if (activity != null) {
            EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, NEXT_SECTION_HOME_SCREEN);
            evaluationListFragment.setArguments(bundle);
            if (isAdd) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, evaluationListFragment)
                        .commit();
            } else {
                FragmentManager manager = getSupportFragmentManager();
                if (manager.getBackStackEntryCount() > 0
                        && !manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1)
                        .getName().equals(EvaluationActivityPresenterImpl.class.getSimpleName())) {
                    popBackStack(manager.getBackStackEntryCount());
                }
            }
        }
    }


    private void recursiveFillSection(EvaluationItem tempEvaluationItem, HashMap valueHashMap) {
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                    Activity activity = getActivity();
                    if (activity != null) {
                        AlertModalManager.createAndShowCancelEvaluationAlertDialog(activity, v -> NavUtils.navigateUpFromSameTask(activity));
                    }
                    return true;
                }
                break;
            case R.id.change_font:
                Activity activity = getActivity();
                if (activity != null) {
                    AlertModalManager.createAndShowChangeFontDialog((AppCompatActivity) activity);
                }
                break;
            case R.id.save_evaluation:
//                onSaveEvaluationButtonClick();
                break;
            case R.id.exit_evaluation:
                if (getActivity() != null) {
                    getActivity().finish();
                }
                break;
        }
        return false;
    }

    public void onSaveEvaluationButtonClick() {
        AppCompatActivity activity = getActivity();
        Log.e("status", "onSaveEvaluation");
        if (activity != null) {
            Log.e("status", "onSaveEvaluation showDialog");
            AlertModalManager.createAndShowSaveEvaluationAlertDialog(getActivity(), v -> {
                HashMap<String, Object> evaluationValueMap = EvaluationDAO.getInstance().loadValues();
                evaluationValueMap.put(ConfigurationParams.EVALUATION_ID, -1);
                EvaluationRequest request = new EvaluationRequest(evaluationValueMap, true);
                RestClient.getInstance(activity).getApi().saveEvaluation(request.toMap()).enqueue(new Callback<EvaluationResponse>() {
                    @Override
                    public void onResponse(Call<EvaluationResponse> call, Response<EvaluationResponse> response) {
                        if (response.isSuccessful()) {
                            if (!response.body().isSuccessful()) {
                                showSnackbarBottomButtonGenericError(activity);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<EvaluationResponse> call, Throwable t) {
                        showSnackbarBottomButtonGenericError(activity);
                    }
                });
                EvaluationDAO.getInstance().clearEvaluation();
                activity.finish();
            }, v -> {
                EvaluationDAO.getInstance().clearEvaluation();
                activity.finish();
            });
        }
    }

    private void showSnackbarBottomButtonGenericError(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getLayout(),
                    R.string.snackbar_bottom_button_unexpected_error_in_save_evaluation, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }
}
