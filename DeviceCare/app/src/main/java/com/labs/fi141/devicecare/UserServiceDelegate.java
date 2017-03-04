package com.labs.fi141.devicecare;

import com.labs.fi141.devicecare.apiModel.SessionToken;

/**
 * Created by eugenius on 2/25/17.
 */

public interface UserServiceDelegate extends ServiceDelegate {

    public void onLoginSuccess(SessionToken token);

    public void onRegisterSuccess(SessionToken token);
}
