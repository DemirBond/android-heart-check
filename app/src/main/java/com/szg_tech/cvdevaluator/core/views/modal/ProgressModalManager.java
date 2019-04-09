package com.szg_tech.cvdevaluator.core.views.modal;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szg_tech.cvdevaluator.R;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class ProgressModalManager {

    private static DialogFragment createAndShowSimpleProgressDialog(Activity activity, String text) {
        DialogFragment newFragment = ProgressDialogFragment.newInstance(text);
        new Handler().postDelayed(() -> newFragment.show(activity.getFragmentManager(), "dialog"),100);
        return newFragment;
    }

    public static DialogFragment createAndShowLoginProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.authenticating_progress_message));
    }

    public static DialogFragment createAndShowRegisterProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.registering_progress_message));
    }

    public static DialogFragment createAndShowComputeEvaluationProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.compute_evaluation_progress_message));
    }

    public static DialogFragment createAndShowRetrieveSavedEvaluationProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.retrieving_saved_evaluations));
    }

    public static DialogFragment createAndShowRetrieveEvaluationProgressDialog(Activity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.retrieving_the_evaluation));
    }

    public static class ProgressDialogFragment extends DialogFragment {

        static String message;

        static ProgressDialogFragment newInstance(String msg) {
            message = msg;
            return new ProgressDialogFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.progress_dialog, container, false);
            View tv = v.findViewById(R.id.message);
            ((TextView)tv).setText(message);
            return v;
        }
    }
}
