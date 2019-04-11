package com.szg_tech.cvdevaluator.fragments.saved_evaluation_list;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.activities.evaluation.EvaluationActivity;
import com.szg_tech.cvdevaluator.core.AbstractPresenter;
import com.szg_tech.cvdevaluator.core.views.modal.ProgressModalManager;
import com.szg_tech.cvdevaluator.rest.api.RestClient;
import com.szg_tech.cvdevaluator.rest.responses.SavedEvaluationItem;
import com.szg_tech.cvdevaluator.rest.responses.SavedEvaluationResponse;
import com.szg_tech.cvdevaluator.storage.EvaluationDAO;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahmetkucuk on 4/5/17.
 */

public class SavedEvaluationPresenterImpl extends AbstractPresenter<SavedEvaluationView> implements SavedEvaluationPresenter {

    private List<SavedEvaluationItem> itemList;
    private String errorMessage;

    public SavedEvaluationPresenterImpl(SavedEvaluationView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
        }
    }

    private void showSnackbarBottomButtonError(Activity activity, String message) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), message, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.saved_evaluation_title);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }
        if (errorMessage != null) {
            showSnackbarBottomButtonError(getActivity(), errorMessage);
        } else if (itemList != null && !itemList.isEmpty()) {
            getView().getRecyclerView().setAdapter(new SavedEvaluationPresenterImpl.SavedEvaluationListRecyclerViewAdapter((AppCompatActivity) getActivity(), itemList));
            getView().getNoDataView().setVisibility(View.GONE);
            getView().getRecyclerView().setVisibility(View.VISIBLE);
        } else {
            getView().getNoDataView().setVisibility(View.VISIBLE);
            getView().getRecyclerView().setVisibility(View.GONE);
        }
    }

    @Override
    public void setData(List<SavedEvaluationItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void setError(String error) {
        this.errorMessage = error;
    }


    class SavedEvaluationListRecyclerViewAdapter extends RecyclerView.Adapter<SavedEvaluationListRecyclerViewAdapter.ViewHolder> {

        private List<SavedEvaluationItem> savedEvaluationItems;
        private AppCompatActivity activity;

        SavedEvaluationListRecyclerViewAdapter(AppCompatActivity activity, List<SavedEvaluationItem> savedEvaluationItems) {
            this.activity = activity;
            this.savedEvaluationItems = savedEvaluationItems;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_evaluation_cell, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final SavedEvaluationItem item = savedEvaluationItems.get(position);
            holder.name.setText(item.getName());
            holder.date.setText(item.getUserFriendlyDateString());
            holder.view.setOnClickListener(new OnSavedEvaluationItemClickListener(savedEvaluationItems.get(position)));
        }

        class OnSavedEvaluationItemClickListener implements View.OnClickListener {

            private SavedEvaluationItem savedEvaluationItem;

            OnSavedEvaluationItemClickListener(SavedEvaluationItem savedEvaluationItem) {
                this.savedEvaluationItem = savedEvaluationItem;
            }

            @Override
            public void onClick(View v) {
                if (activity != null) {
                    DialogFragment progressDialog = ProgressModalManager.createAndShowRetrieveEvaluationProgressDialog(activity);
                    RestClient.getInstance(activity).getApi().retrieveEvaluationByID(savedEvaluationItem.getId()).enqueue(new Callback<SavedEvaluationResponse>() {
                        @Override
                        public void onResponse(Call<SavedEvaluationResponse> call, Response<SavedEvaluationResponse> response) {
                            if (progressDialog != null) {
                                progressDialog.dismiss();
                            }
                            if (response.isSuccessful()) {
                                SavedEvaluationResponse savedEvaluationResponse = response.body();
                                Map<String, Object> evaluationValues = savedEvaluationResponse.parseEvaluationInputs();
                                EvaluationDAO.getInstance().addAllToHashMap(evaluationValues);
                                EvaluationDAO.getInstance().saveValues();
                                getView().startActivity(EvaluationActivity.class);
                            } else {
                                showSnackbarBottomButtonError(getActivity(), getActivity().getResources().getString(R.string.compute_evaluation_progress_message));
                            }
                        }

                        @Override
                        public void onFailure(Call<SavedEvaluationResponse> call, Throwable t) {
                            if (progressDialog != null) {
                                progressDialog.dismiss();
                            }
                            t.printStackTrace();
                            showSnackbarBottomButtonError(getActivity(), getActivity().getResources().getString(R.string.compute_evaluation_progress_message));
                        }
                    });
                }
            }
        }

        @Override
        public int getItemCount() {
            return savedEvaluationItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public View view;
            public TextView name;
            public TextView date;

            public ViewHolder(View v) {
                super(v);
                view = v;
                name = v.findViewById(R.id.name);
                date = v.findViewById(R.id.date);
            }
        }

    }

}
