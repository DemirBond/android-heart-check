package com.szg_tech.cvdevaluator.rest.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.szg_tech.cvdevaluator.storage.PreferenceHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public class RestClient
{
    //private static final String BASE_URL = "http://198.71.134.8/";

    public static final String BASE_URL = "http://pulmonaryhypertensionexpert.com/";

    private ApiService apiService;

    private static RestClient instance;

    private RestClient(){

    }

    public static RestClient getInstance(Context context){
        if(instance==null){
            instance = new RestClient();
            instance.init(PreferenceHelper.getLastToken(context));
        }
        return instance;
    }

    public void init(String token) {
        Gson gson = new GsonBuilder().create();

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new AuthenticationInterceptor(token));
        builder
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        apiService = restAdapter.create(ApiService.class);
    }

    public ApiService getApi() {
        return apiService;
    }
}
