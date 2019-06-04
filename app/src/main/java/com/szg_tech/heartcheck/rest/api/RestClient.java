package com.szg_tech.heartcheck.rest.api;

import android.content.Context;

import com.szg_tech.heartcheck.storage.PreferenceHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public class RestClient {
    //private static final String BASE_URL = "http://198.71.134.8/";

    public static final String BASE_URL = "http://pulmonaryhypertensionexpert.com/";

    private ApiService apiService;

    private static RestClient instance;

    private RestClient() {

    }

    public static RestClient getInstance(Context context) {
        if (instance == null) {
            instance = new RestClient();
            instance.init(PreferenceHelper.getLastToken(context));
        }
        return instance;
    }

    public void init(String token) {
        // Add the interceptor to OkHttpClient
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new AuthenticationInterceptor(token));
        builder.connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging);
        OkHttpClient client = builder.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = restAdapter.create(ApiService.class);
    }

    public ApiService getApi() {
        return apiService;
    }
}
