package com.labs.fi141.devicecare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.labs.fi141.devicecare.api.UserService;

public class LoginActivity extends AppCompatActivity {

    UserService service = new UserService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClick(View sender) {
        service.login("abc", "def");
    }
}
