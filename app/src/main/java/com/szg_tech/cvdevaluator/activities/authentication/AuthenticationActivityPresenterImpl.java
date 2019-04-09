package com.szg_tech.cvdevaluator.activities.authentication;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.AbstractPresenter;
import com.szg_tech.cvdevaluator.core.NetworkConnectivityControl;
import com.szg_tech.cvdevaluator.core.views.modal.AlertModalManager;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class AuthenticationActivityPresenterImpl extends AbstractPresenter<AuthenticationActivityView> implements AuthenticationActivityPresenter, NetworkConnectivityControl.OnNetworkNotUsableListener {


    AuthenticationActivityPresenterImpl(AuthenticationActivityView view) {
        super(view);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        checkInternet();
    }

    private void checkInternet() {
        Activity activity = getActivity();
        if(activity != null) {
            new NetworkConnectivityControl(getActivity(), this).execute();
        }
    }


    @Override
    public void onNetworkConnectionFailed() {
        Activity activity = getActivity();
        if(activity != null) {
            AlertModalManager.createAndShowNoInternetConnectionAlertDialog(activity, (v) -> activity.onBackPressed());
        }
    }
}
