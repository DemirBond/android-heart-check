package com.szg_tech.heartcheck.activities.authentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.activities.main.MainActivity;
import com.szg_tech.heartcheck.fragments.login.LoginFragment;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class AuthenticationActivity extends AppCompatActivity implements AuthenticationActivityView {
    private AuthenticationActivityPresenter presenter = createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new LoginFragment())
                .addToBackStack(LoginFragment.class.getSimpleName())
                .commit();

        presenter.onCreate();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public AuthenticationActivityPresenter createPresenter() {
        return new AuthenticationActivityPresenterImpl(this);
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    @Override
    public void onLoginSucceed() {
        startActivity(MainActivity.class);
    }
}
