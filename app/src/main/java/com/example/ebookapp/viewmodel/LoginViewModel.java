package com.example.ebookapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookapp.auth.FirebaseLogin;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends AndroidViewModel {

    //Getting the data from dbs performs via model classes in View Model so FirebaseLogin will use here.
    private final FirebaseLogin fLogin;
    private final MutableLiveData<FirebaseUser> userLiveData;
    private final MutableLiveData<Boolean> loggedOutLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);

        fLogin = new FirebaseLogin(application);
        userLiveData = fLogin.getUserLiveData();
        loggedOutLiveData = fLogin.getLoggedOutLiveData();
    }

    public void logOut() {
        fLogin.logOut();
    }

    public void login(String email, String password) {
        fLogin.login(email, password);
    }


    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }
}
