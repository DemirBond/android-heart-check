package com.szg_tech.cvdevaluator.activities.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.rest.requests.LoginCall;
import com.szg_tech.cvdevaluator.activities.main.MainActivity;

/**
 * Created by superlight on 7/22/2017 AD.
 */

public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        startAnimation();

        long loginCallTime = System.currentTimeMillis();
        new LoginCall().tryLogin(this, new LoginCall.OnLogin() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

            @Override
            public void onFailed() {
                long delay = System.currentTimeMillis() -loginCallTime;
                if(delay>100){
                    new Handler().postDelayed(() -> {
                        goToAuthActivity();
                    }, delay);
                } else {
                    goToAuthActivity();
                }
            }
        });
    }

    private void goToAuthActivity(){
        startActivity(new Intent(getApplicationContext(), AuthenticationActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void startAnimation(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ImageView ivLogo = findViewById(R.id.iv_logo);
        ivLogo.clearAnimation();
        ivLogo.startAnimation(anim);
    }

}
