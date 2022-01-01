package com.example.ebookapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ebookapp.data.model.User;
import com.example.ebookapp.repository.UserRepository;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {
    private UserRepository mRepository;


    public RegisterViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
    }

    public void insert(User user) {
        mRepository.insert(user);
    }
}
