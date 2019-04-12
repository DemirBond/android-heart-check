package com.szg_tech.heartcheck.rest.requests;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.rest.api.RestClient;
import com.szg_tech.heartcheck.rest.responses.SavedEvaluationItem;
import com.szg_tech.heartcheck.rest.responses.SavedEvaluationSummaryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSavedEvaluationsCall {

    public interface OnSavedEvaluationsResult {
        void onNoInternet();
        void onResultSuccessful(List<SavedEvaluationItem> itemList);
        void onError(String error);
    }

    public void getEvaluations(OnSavedEvaluationsResult callback, Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = null;
        if (conMgr != null) {
            netInfo = conMgr.getActiveNetworkInfo();
        }
        if (netInfo == null){   // fetch evaluations from local storage
            callback.onNoInternet();
        } else {  // retrieve saved evaluations
            RestClient.getInstance(context).getApi().retrieveSavedEvaluations().enqueue(new Callback<SavedEvaluationSummaryResponse>() {
                @Override
                public void onResponse(Call<SavedEvaluationSummaryResponse> call, Response<SavedEvaluationSummaryResponse> response) {
                    if(response.isSuccessful()) {
                        SavedEvaluationSummaryResponse savedEvaluationSummaryResponse = response.body();
                        if(savedEvaluationSummaryResponse.isSuccessful()) {
                            callback.onResultSuccessful(savedEvaluationSummaryResponse.getEvals());
                        } else {
                            callback.onError(savedEvaluationSummaryResponse.getMessage());
                        }
                    } else {
                        System.out.println(response.errorBody());
                        callback.onError(context.getResources().getString(R.string.retrieving_saved_evaluations_error));
                    }
                }
                @Override
                public void onFailure(Call<SavedEvaluationSummaryResponse> call, Throwable t) {
                    callback.onError(context.getResources().getString(R.string.retrieving_saved_evaluations_error));
                }
            });
        }
    }
}
