package com.szg_tech.cvdevaluator.rest.requests;

import android.content.Context;

import com.szg_tech.cvdevaluator.rest.api.RestClient;
import com.szg_tech.cvdevaluator.rest.authentication.AuthenticationClient;
import com.szg_tech.cvdevaluator.rest.responses.LoginResponse;
import com.szg_tech.cvdevaluator.storage.PreferenceHelper;
import com.szg_tech.cvdevaluator.storage.entities.Credentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCall {

    public void tryLogin(Context context, OnLogin callback){
        Credentials credentials = PreferenceHelper.getCredentials(context);
        if(!credentials.isEmpty()) {
            tryLogin(credentials.getEmail(), credentials.getPassword(), context, callback);
        } else {
            callback.onFailed();
        }
    }

    public void tryLogin(String email, String password, Context context, OnLogin callback){
        new AuthenticationClient().getAuthenticationService().login(new LoginRequest(email, password).getPlainBody())
            .enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(response.isSuccessful()) {
                        if(response.body().isSucceed()) {
                            long expireDate = System.currentTimeMillis() + (response.body().getExpiresIn() * 1000);
                            String token = response.body().getAccessToken();
                            Credentials newCredentials = new Credentials(email, password, token, expireDate);
                            RestClient.getInstance(context).init(token);
                            PreferenceHelper.putCredentials(context, newCredentials);
                            if(callback!=null){
                                callback.onSuccess();
                            }
                        }
                    } else {
                        if(callback!=null){
                            callback.onFailed();
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    if(callback!=null){
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
