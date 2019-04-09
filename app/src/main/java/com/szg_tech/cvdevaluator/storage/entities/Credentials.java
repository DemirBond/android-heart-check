package com.szg_tech.cvdevaluator.storage.entities;

/**
 * Created by ahmetkucuk on 3/26/17.
 */

public class Credentials {

    public static final String TOKEN = "token";
    public static final String EXPIRE_DATE = "expireDate";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String LAST_TIME_USED = "last_time_used";
    public static final String TOS_ACCEPTED = "tos_accepted";

    private String token;
    private long expireDate;
    private String email;
    private String password;


    public Credentials(String email, String password, String token, long expireDate) {
        this.email = email;
        this.password = password;
        this.token = token;
        this.expireDate = expireDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(long expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() >= expireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmpty(){

        if(email == null || email.isEmpty()) return true;
        return password == null || password.isEmpty();

    }
}
