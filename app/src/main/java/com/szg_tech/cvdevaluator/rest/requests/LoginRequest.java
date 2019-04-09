package com.szg_tech.cvdevaluator.rest.requests;

import com.google.gson.annotations.SerializedName;

import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginRequest {

    @SerializedName("grant_type")
    private String grantType;
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.grantType = "password";
        this.username = username;
        this.password = password;
    }

    public String getPlainBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("grant_type=");
        builder.append(grantType);
        builder.append("&username=");
        builder.append(username);
        builder.append("&password=");
        builder.append(password);
        return builder.toString();
    }
}
