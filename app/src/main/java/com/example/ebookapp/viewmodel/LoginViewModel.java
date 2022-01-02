package com.example.ebookapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookapp.auth.FirebaseLogin;
import com.example.ebookapp.data.model.User;
import com.example.ebookapp.repository.UserRepository;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {

    //Getting the data from dbs performs via model classes in View Model so FirebaseLogin will use here.
    private FirebaseLogin fLogin;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);

        fLogin = new FirebaseLogin(application);
        userLiveData = fLogin.getUserLiveData();
        loggedOutLiveData = fLogin.getLoggedOutLiveData();
    }

    public void logOut() {
        fLogin.logOut();
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }
}
