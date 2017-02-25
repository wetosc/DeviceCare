package com.labs.fi141.devicecare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.labs.fi141.devicecare.api.UserService;
import com.labs.fi141.devicecare.model.SessionToken;

public class LoginActivity extends AppCompatActivity implements UserServiceDelegate {

    UserService service = new UserService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service.setDelegate(this);
    }

    public void loginClick(View sender) {
        service.login("abc", "def");
    }

    // API Service methods
    @Override
    public void onLoginSuccess(SessionToken token) {
        Toast.makeText(this, token.getToken(), Toast.LENGTH_LONG);
    }

    @Override
    public void onRegisterSuccess(SessionToken token) {
        Toast.makeText(this, token.getToken(), Toast.LENGTH_SHORT);
    }

    @Override
    public void onError(Error error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT);
    }
}
