package com.szg_tech.cvdevaluator.rest.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmetkucuk on 4/5/17.
 */

public class BaseResponse {

    private static final String CODE_SUCCEED = "OK";

    @SerializedName("stat")
    protected String status;

    @SerializedName("msg")
    protected String message;


    public boolean isSuccessful(){
        return status.equalsIgnoreCase(CODE_SUCCEED);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
