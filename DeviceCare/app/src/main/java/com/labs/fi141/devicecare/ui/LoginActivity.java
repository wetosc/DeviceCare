package com.labs.fi141.devicecare.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.labs.fi141.devicecare.R;
import com.labs.fi141.devicecare.UserServiceDelegate;
import com.labs.fi141.devicecare.api.UserService;
import com.labs.fi141.devicecare.apiModel.SessionToken;
import com.labs.fi141.devicecare.model.UserStorage;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements UserServiceDelegate {

    UserService service = new UserService();

    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service.setDelegate(this);

        String token = UserStorage.getToken();
        if (token != null) {
            loggedIn(token);
        }

        configureTabs();
    }


    void configureTabs() {

        ArrayList<CharSequence> titles = new ArrayList<>();
        titles.add("Login");
        titles.add("Register");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)), true);
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, fragments);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    // Button Click

    public void loginClick(View sender) {
        View loginView = adapter.fragments.get(0).getView();
        TextView emailField = (TextView) loginView.findViewById(R.id.emailField);
        TextView passwordField = (TextView) loginView.findViewById(R.id.passwordField);

        service.login(emailField.getText().toString(), passwordField.getText().toString());
    }

    public void registerClick(View sender) {
        View registerView = adapter.fragments.get(1).getView();
        TextView emailField = (TextView) registerView.findViewById(R.id.emailField);
        TextView passwordField = (TextView) registerView.findViewById(R.id.passwordField);
        TextView firstNameField = (TextView) registerView.findViewById(R.id.firstNameField);
        TextView lastNameField = (TextView) registerView.findViewById(R.id.lastNameField);

        service.register(firstNameField.getText().toString(),
                lastNameField.getText().toString(),
                emailField.getText().toString(),
                passwordField.getText().toString());
    }


    private void loggedIn(String token) {
        Intent intent = new Intent(LoginActivity.this, DevicesActivity.class);
        intent.putExtra("token", token);
        startActivity(intent);
    }

    // API Service methods
    @Override
    public void onLoginSuccess(SessionToken token) {
        Toast.makeText(this, token.getToken(), Toast.LENGTH_SHORT).show();
        loggedIn(token.getToken());
    }

    @Override
    public void onRegisterSuccess(SessionToken token) {
        Toast.makeText(this, token.getToken(), Toast.LENGTH_SHORT).show();
        loggedIn(token.getToken());
    }

    @Override
    public void onError(Error error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
    }
}
