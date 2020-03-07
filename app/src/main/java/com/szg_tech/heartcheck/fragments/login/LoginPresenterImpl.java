package com.szg_tech.heartcheck.fragments.login;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.activities.authentication.AuthenticationActivity;
import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.views.modal.ProgressModalManager;
import com.szg_tech.heartcheck.fragments.register.RegisterFragment;
import com.szg_tech.heartcheck.rest.requests.LoginCall;
import com.szg_tech.heartcheck.storage.PreferenceHelper;
import com.szg_tech.heartcheck.storage.entities.Credentials;


/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class LoginPresenterImpl extends AbstractPresenter<LoginView> implements LoginPresenter {

    LoginPresenterImpl(LoginView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new LoginPresenterImpl.RecyclerViewAdapter(activity));
        }
        checkCredentials();
    }

    @Override
    public void onResume() {

        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.login);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }
    }

    private void checkCredentials() {
        Credentials credentials = PreferenceHelper.getCredentials(getActivity());
        if (!credentials.isEmpty()) {
            tryLogin(credentials.getEmail(), credentials.getPassword());
        }
    }

    private void tryLogin(String email, String password) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        final DialogFragment progressDialog = ProgressModalManager.createAndShowLoginProgressDialog(activity);

        new LoginCall().tryLogin(email, password, getActivity(), new LoginCall.OnLogin() {
            @Override
            public void onSuccess() {
                if (!activity.isDestroyed()) {
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    ((AuthenticationActivity) activity).onLoginSucceed();
                }
            }

            @Override
            public void onFailed() {
                if (!activity.isDestroyed()) {
                    if (progressDialog != null) {
                        progressDialog.dismissAllowingStateLoss();
                    }
                }
                showSnackbarBottomButtonLoginError(activity);
            }
        });
    }

    private void showSnackbarBottomButtonLoginError(AppCompatActivity activity) {
        if (activity != null) {
            try {
                Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_login_error, Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
                snackbar.show();
            } catch (IllegalArgumentException ex) {
                Log.d("Login Presenter", "No view for snackbar!");
            }

        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<LoginPresenterImpl.RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;

        RecyclerViewAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public LoginPresenterImpl.RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.login_layout, parent, false);
            return new LoginPresenterImpl.RecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(LoginPresenterImpl.RecyclerViewAdapter.ViewHolder holder, int position) {
            holder.loginButton.setOnClickListener(new LoginOnClickLister(holder));
            holder.linkSignup.setOnClickListener(v -> {
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.container, new RegisterFragment())
                        .addToBackStack(RegisterFragment.class.getSimpleName())
                        .commit();
            });
        }

        class LoginOnClickLister implements View.OnClickListener {

            final ViewHolder holder;

            public LoginOnClickLister(ViewHolder holder) {
                this.holder = holder;
            }

            @Override
            public void onClick(View v) {
                System.out.println("I am in LoginFragment on click");
                String email = holder.email.getText().toString();
                String password = holder.password.getText().toString();
                if (validate()) {
                    tryLogin(email, password);
                }
            }

            private boolean validate() {
                boolean valid = true;

                String email = holder.email.getText().toString();
                String password = holder.password.getText().toString();

                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    holder.email.setError("enter a valid email address");
                    valid = false;
                } else {
                    holder.password.setError(null);
                }

                if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                    holder.password.setError("between 4 and 10 alphanumeric characters");
                    valid = false;
                } else {
                    holder.password.setError(null);
                }

                return valid;
            }
        }

        @Override
        public int getItemCount() {
            return 1;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            View view;
            TextView email;
            TextView password;
            TextView loginButton;
            TextView linkSignup;

            ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                email = itemView.findViewById(R.id.input_email);
                password = itemView.findViewById(R.id.input_password);
                linkSignup = itemView.findViewById(R.id.link_signup);
                loginButton = itemView.findViewById(R.id.btn_login);
            }
        }
    }
}
