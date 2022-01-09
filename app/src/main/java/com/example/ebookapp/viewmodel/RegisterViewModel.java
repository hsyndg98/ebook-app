package com.example.ebookapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookapp.RemoteDB.FirebaseLogin;
import com.google.firebase.auth.FirebaseUser;

public class RegisterViewModel extends AndroidViewModel {
    private FirebaseLogin fRegister;
    private MutableLiveData<FirebaseUser> userLiveData;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        fRegister = new FirebaseLogin(application);
        userLiveData = fRegister.getUserLiveData();
    }

    public void login(String email, String password) {
        fRegister.login(email, password);
    }

    public void add_user_to_realtimeDB(String fullname,String mail, String uid){ fRegister.add_user_to_realtime_db(fullname,mail,uid); }


    public void register(String email, String password) {
        fRegister.register(email, password);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }
}
