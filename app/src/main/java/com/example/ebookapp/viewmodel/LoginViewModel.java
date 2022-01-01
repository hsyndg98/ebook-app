package com.example.ebookapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ebookapp.data.model.User;
import com.example.ebookapp.repository.UserRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private UserRepository mRepository;

    private final LiveData<List<User>> mAllUsers;
    private User mOneUser;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getmAllUsers();
    }

    LiveData<List<User>> getAllUsers(){return mAllUsers;}

    User getmOneUser(String email, String password){
        return mRepository.findOneUser(email, password);
    }
}
