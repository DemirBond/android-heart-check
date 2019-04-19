package com.szg_tech.heartcheck.activities.evaluation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.activities.authentication.AuthenticationActivity;
import com.szg_tech.heartcheck.core.views.modal.AlertModalManager;
import com.szg_tech.heartcheck.entities.evaluation_items.HeartSpecialistManagement;

public class EvaluationActivity extends AppCompatActivity implements EvaluationActivityView {
    EvaluationActivityPresenter presenter = createPresenter();
    private Runnable onBackPressedListener;
    private HeartSpecialistManagement heartSpecialistManagement;
    private View mainView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        mainView = findViewById(R.id.activity_main);
        heartSpecialistManagement = new HeartSpecialistManagement(this);
        presenter.onCreate();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public EvaluationActivityPresenter createPresenter() {
        return new EvaluationActivityPresenterImpl(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.evaluation_menu, menu);
        return true;
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
    }

    public void setOnBackPressedListener(Runnable runnable) {
        onBackPressedListener = runnable;
    }

    public void createHomeScreen(boolean isAdd) {
        presenter.createHomeScreen(isAdd);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            AlertModalManager.createAndShowCancelEvaluationAlertDialog(this, v -> super.onBackPressed());
        } else if (onBackPressedListener != null) {
            onBackPressedListener.run();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public HeartSpecialistManagement getHeartSpecialistManagement() {
        return heartSpecialistManagement;
    }

    @Override
    public void onSessionExpired() {
        if(getActivity() != null) {
            Intent a = new Intent(getActivity(), AuthenticationActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            getActivity().startActivity(a);
            getActivity().finish();
        }
    }

    @Override
    public View getLayout() {
        return mainView;
    }
}
