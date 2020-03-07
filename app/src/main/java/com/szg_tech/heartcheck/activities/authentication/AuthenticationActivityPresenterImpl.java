package com.szg_tech.heartcheck.activities.authentication;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;

import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.NetworkConnectivityControl;
import com.szg_tech.heartcheck.core.views.modal.AlertModalManager;

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
        AppCompatActivity activity = getActivity();
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
