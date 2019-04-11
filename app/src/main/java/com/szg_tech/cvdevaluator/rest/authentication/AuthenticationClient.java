package com.szg_tech.cvdevaluator.rest.authentication;

import com.szg_tech.cvdevaluator.rest.api.RestClient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class AuthenticationClient {

    private AuthenticationService authenticationService;

    public AuthenticationClient() {
        // Add the interceptor to OkHttpClient
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addInterceptor(logging);
        OkHttpClient client = builder.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(RestClient.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        authenticationService = restAdapter.create(AuthenticationService.class);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
