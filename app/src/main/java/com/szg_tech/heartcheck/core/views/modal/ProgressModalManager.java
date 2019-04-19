package com.szg_tech.heartcheck.core.views.modal;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szg_tech.heartcheck.R;

import java.util.Objects;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class ProgressModalManager {

    private static DialogFragment createAndShowSimpleProgressDialog(AppCompatActivity activity, String text) {
        DialogFragment newFragment = ProgressDialogFragment.newInstance(text);
        new Handler().postDelayed(() -> newFragment.show(activity.getSupportFragmentManager(), "dialog"), 100);
        return newFragment;
    }

    public static DialogFragment createAndShowLoginProgressDialog(AppCompatActivity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.authenticating_progress_message));
    }

    public static DialogFragment createAndShowRegisterProgressDialog(AppCompatActivity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.registering_progress_message));
    }

    public static DialogFragment createAndShowComputeEvaluationProgressDialog(AppCompatActivity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.compute_evaluation_progress_message));
    }

    public static DialogFragment createAndShowRetrieveSavedEvaluationProgressDialog(AppCompatActivity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.retrieving_saved_evaluations));
    }

    public static DialogFragment createAndShowRetrieveEvaluationProgressDialog(AppCompatActivity activity) {
        return createAndShowSimpleProgressDialog(activity, activity.getResources().getString(R.string.retrieving_the_evaluation));
    }

    public static class ProgressDialogFragment extends DialogFragment {

        static String message;

        static ProgressDialogFragment newInstance(String msg) {
            message = msg;
            return new ProgressDialogFragment();
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//            return super.onCreateDialog(savedInstanceState);
            Dialog dialog = new Dialog(Objects.requireNonNull(getContext()));
            dialog.setCanceledOnTouchOutside(false);
            return dialog;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.progress_dialog, container, false);
            View tv = v.findViewById(R.id.message);
            ((TextView) tv).setText(message);
            return v;
        }
    }
}
