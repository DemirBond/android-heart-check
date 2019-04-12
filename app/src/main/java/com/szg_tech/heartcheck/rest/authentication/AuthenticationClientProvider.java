package com.szg_tech.heartcheck.rest.authentication;

/**
 * Created by ahmetkucuk on 4/2/17.
 */

public class AuthenticationClientProvider {

    private static final AuthenticationClient authenticationClient = new AuthenticationClient();

    public static AuthenticationClient get() {
        return authenticationClient;
    }

}
