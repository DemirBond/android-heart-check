package com.szg_tech.heartcheck.rest.requests;

import android.content.Context;
import android.util.Log;

import com.szg_tech.heartcheck.rest.api.RestClient;
import com.szg_tech.heartcheck.rest.authentication.AuthenticationClient;
import com.szg_tech.heartcheck.rest.responses.LoginResponse;
import com.szg_tech.heartcheck.storage.PreferenceHelper;
import com.szg_tech.heartcheck.storage.entities.Credentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCall {

    public void tryLogin(Context context, OnLogin callback) {
        Log.e("status", "tryLogin in cache");
        Credentials credentials = PreferenceHelper.getCredentials(context);
        if (!credentials.isEmpty()) {
            tryLogin(credentials.getEmail(), credentials.getPassword(), context, callback);
        } else {
            callback.onFailed();
        }
    }

    public void tryLogin(String email, String password, Context context, OnLogin callback) {
        Log.e("status", "tryLogin");
        new AuthenticationClient().getAuthenticationService().login(new LoginRequest(email, password).getPlainBody())
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful() && response.body().isSucceed()) {
                            long expireDate = System.currentTimeMillis() + (response.body().getExpiresIn() * 1000);
                            String token = response.body().getAccessToken();
                            Credentials newCredentials = new Credentials(email, password, token, expireDate);
                            PreferenceHelper.putCredentials(context, newCredentials);
                            RestClient.getInstance(context).init(token);
                            if (callback != null) {
                                callback.onSuccess();
                            }
                        } else {
                            if (callback != null) {
                                callback.onFailed();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        if (callback != null) {
                            callback.onFailed();
                        }
                    }
                });
    }

    public interface OnLogin {
        void onSuccess();

        void onFailed();
    }
}
