package com.example.ebookapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.ebookapp.data.database.EbookDatabase;
import com.example.ebookapp.data.database.UserDao;
import com.example.ebookapp.data.model.User;
import java.util.List;

public class UserRepository {
    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;
    private User mOneUser;

    public UserRepository(Application application){
        EbookDatabase db = EbookDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mAllUsers = mUserDao.getAll();

    }
    public LiveData<List<User>> getmAllUsers(){
        return mAllUsers;
    }
    public void insert(User user){
        EbookDatabase.databaseWriteExecutor.execute(() -> {
            mUserDao.insert(user);
        });
    }
    public User findOneUser(String email, String password){
        mOneUser = mUserDao.findByMailAndPassword(email,password);
        return mOneUser;
    }
}
