package com.szg_tech.heartcheck.fragments.output;

import android.app.Activity;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.activities.evaluation.EvaluationActivity;
import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.ConfigurationParams;
import com.szg_tech.heartcheck.core.OutputRecyclerViewAdapter;
import com.szg_tech.heartcheck.core.views.modal.AlertModalManager;
import com.szg_tech.heartcheck.core.views.modal.ProgressModalManager;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.TextEvaluationItem;
import com.szg_tech.heartcheck.rest.api.RestClient;
import com.szg_tech.heartcheck.rest.requests.EvaluationRequest;
import com.szg_tech.heartcheck.rest.responses.EvaluationGroup;
import com.szg_tech.heartcheck.rest.responses.EvaluationResponse;
import com.szg_tech.heartcheck.rest.responses.Field;
import com.szg_tech.heartcheck.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class OutputPresenterImpl extends AbstractPresenter<OutputView> implements OutputPresenter {

    OutputPresenterImpl(OutputView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            recyclerView.setAdapter(new OutputRecyclerViewAdapter(activity, new ArrayList<>()));
            computeAndShowEvaluations(activity, recyclerView);
        }
    }

    private void showSnackbarBottomButtonGenericError(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(),
                    R.string.snackbar_bottom_button_unexpected_error_in_compute_evaluation, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    private void showSnackbarBottomButtonGenericSaveError(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(),
                    R.string.snackbar_bottom_button_unexpected_error_in_save_evaluation, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    private void showSnackbarBottomButtonUnAuthorizedError(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(),
                    R.string.snackbar_bottom_button_session_expire_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    public void computeAndShowEvaluations(AppCompatActivity activity, RecyclerView recyclerView) {

        DialogFragment progressDialog = ProgressModalManager.createAndShowComputeEvaluationProgressDialog((AppCompatActivity) getActivity());
        HashMap<String, Object> evaluationValueMap = EvaluationDAO.getInstance().loadValues();
        EvaluationRequest request = new EvaluationRequest(evaluationValueMap, false);
        System.out.println(request.toMap());

        RestClient.getInstance(activity).getApi().computeEvaluation(request.toMap()).enqueue(new Callback<EvaluationResponse>() {
            @Override
            public void onResponse(Call<EvaluationResponse> call, Response<EvaluationResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccessful()) {
                        List<EvaluationItem> evaluationItems = createEvaluationList(response.body());
                        recyclerView.setAdapter(new OutputRecyclerViewAdapter(activity, evaluationItems));
                    } else {
                        showSnackbarBottomButtonGenericError(activity);
                    }
                } else {
                    if (response.code() == 401) {
                        showSnackbarBottomButtonUnAuthorizedError(activity);
                        if (activity instanceof EvaluationActivity) {
                            ((EvaluationActivity) activity).onSessionExpired();
                        }
                    } else {
                        showSnackbarBottomButtonGenericError(activity);
                    }
                }
                if (progressDialog != null) {
                    activity.getSupportFragmentManager().beginTransaction().remove(progressDialog).commitAllowingStateLoss();
                }
            }

            @Override
            public void onFailure(Call<EvaluationResponse> call, Throwable t) {
                if (progressDialog != null) {
                    activity.getSupportFragmentManager().beginTransaction().remove(progressDialog).commitAllowingStateLoss();
                }
                t.printStackTrace();
                showSnackbarBottomButtonGenericError(activity);
            }
        });
    }

    @Override
    public void onReturnToEvaluationButtonClick() {
        popBackStack();
    }

    @Override
    public void onSaveEvaluationButtonClick() {
        Activity activity = getActivity();
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
                                showSnackbarBottomButtonGenericSaveError((AppCompatActivity) activity);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<EvaluationResponse> call, Throwable t) {
                        showSnackbarBottomButtonGenericSaveError((AppCompatActivity) activity);
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

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity != null && activity instanceof AppCompatActivity) {
            if (!activity.isDestroyed()) {
                ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setTitle(R.string.output);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                popBackStack();
                break;
            case R.id.save_evaluation:
                onSaveEvaluationButtonClick();
                break;
        }
        return true;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.home).setVisible(false);
        menu.findItem(R.id.reset_field).setVisible(false);
    }

    /**
     * TODO use special item displays e.g. HeartPartnerEvaluationItem
     *
     * @param response
     * @return List of Evaluation Items to be displayed in ListView
     */
    public List<EvaluationItem> createEvaluationList(EvaluationResponse response) {
        List<EvaluationItem> evaluationItems = new ArrayList<>();
        for (EvaluationGroup group : response.getOutputs()) {

            evaluationItems.add(new BoldEvaluationItem(ConfigurationParams.OVERVIEW, group.getGroupname()));
            if (group.getFields() != null) {
                for (Field f : group.getFields()) {
                    evaluationItems.add(new TextEvaluationItem(f.getPar(), f.getVal()));
                }
            }
        }
        return evaluationItems;
    }
}
