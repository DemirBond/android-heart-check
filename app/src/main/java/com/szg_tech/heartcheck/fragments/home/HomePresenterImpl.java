package com.szg_tech.heartcheck.fragments.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.activities.evaluation.EvaluationActivity;
import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.views.modal.ProgressModalManager;
import com.szg_tech.heartcheck.fragments.saved_evaluation_list.SavedEvaluationFragment;
import com.szg_tech.heartcheck.rest.requests.GetSavedEvaluationsCall;
import com.szg_tech.heartcheck.rest.responses.SavedEvaluationItem;
import com.szg_tech.heartcheck.storage.EvaluationDAO;
import com.szg_tech.heartcheck.utiles.listeners.OnLockClickListener;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

class HomePresenterImpl extends AbstractPresenter<HomeView> implements HomePresenter, GetSavedEvaluationsCall.OnSavedEvaluationsResult {

    HomePresenterImpl(HomeView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new RecyclerViewAdapter(activity));
        }
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowCustomEnabled(false);
                actionBar.setTitle(R.string.heart_check);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }
    }

    public void onResultSuccessful(List<SavedEvaluationItem> itemList) {
        if (mLockSavedEvaluationListener != null) {
            mLockSavedEvaluationListener.unlock();
        }
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        SavedEvaluationFragment fragment = new SavedEvaluationFragment();
        fragment.createPresenter().setData(itemList);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(getSupportFragmentManager().getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    public void onError(String error) {
        if (mLockSavedEvaluationListener != null) {
            mLockSavedEvaluationListener.unlock();
        }
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        showSnackbarBottomButtonError(getActivity(), error);
    }

    public void onNoInternet() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        showSnackbarBottomButtonError(getActivity(), getActivity().getResources().getString(R.string.retrieving_saved_evaluations_error));
    }

    private void showSnackbarBottomButtonError(AppCompatActivity activity, String message) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), message, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    DialogFragment progressDialog;
    OnLockClickListener mLockSavedEvaluationListener;

    private void openSavedEvaluationsFragment() {
        progressDialog = ProgressModalManager.createAndShowRetrieveSavedEvaluationProgressDialog((AppCompatActivity) getActivity());
        new GetSavedEvaluationsCall().getEvaluations(this, getActivity());
    }


    private void openNewEvaluationActivity() {
        EvaluationDAO.getInstance().clearEvaluation();
        getView().startActivity(EvaluationActivity.class);
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;

        RecyclerViewAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.home_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
            if (position == 0) {
                holder.image.setImageResource(R.drawable.clipboard);
                holder.title.setText(R.string.new_evaluation_title);
                holder.description.setText(R.string.new_evaluation_description);
                holder.view.setOnClickListener(v -> openNewEvaluationActivity());
            } else if (position == 1) {
                holder.image.setImageResource(R.drawable.locked);
                holder.title.setText(R.string.saved_evaluation_title);
                holder.description.setText(R.string.saved_evaluation_desription);
                holder.image.setImageResource(R.drawable.folder);
                holder.view.setOnClickListener(new OnLockClickListener(new Function2<View, OnLockClickListener, Unit>() {
                    @Override
                    public Unit invoke(View view, OnLockClickListener onLockClickListener) {
                        mLockSavedEvaluationListener = onLockClickListener;
                        openSavedEvaluationsFragment();
                        return null;
                    }
                }));
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            View view;
            ImageView image;
            TextView title;
            TextView description;

            ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                image = itemView.findViewById(R.id.image);
                title = itemView.findViewById(R.id.title);
                description = itemView.findViewById(R.id.description);
            }
        }
    }
}
