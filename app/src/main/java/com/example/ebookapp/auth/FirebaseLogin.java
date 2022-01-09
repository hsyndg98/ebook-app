package com.example.ebookapp.auth;

import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseLogin {

    Application application; //This variable helps to hold activity's instance.
    private FirebaseAuth mAuth; //This variable uses for auth processes.

    //This variables uses the live data to determine user' login status.
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;

    //Constructor func.
    public FirebaseLogin(Application application){

        //We will assign the neccessary variables.
        this.application = application;
        this.mAuth = FirebaseAuth.getInstance();
        this.userLiveData = new MutableLiveData<>();
        this.loggedOutLiveData = new MutableLiveData<>();

        //If user has logged the system, user uid will add the userLiveData array.
        if(mAuth.getCurrentUser() != null){
            userLiveData.postValue(mAuth.getCurrentUser());
            loggedOutLiveData.postValue(false);
        }

    }

    //This function logins the user to app.
    public void login(String email, String password) {

        //We need the version control of android, because of code structure.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //If task is successful, user id adds the userLiveData array.
                                userLiveData.postValue(mAuth.getCurrentUser()); //Sends the user id in firebase the userLiveData.
                            } else {

                                //An error message is displayed showing the reason for the user not being able to login.
                                Toast.makeText(application.getApplicationContext(), "Login Failure: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    //User registers the system via his/her password and email.
    public void register(String email, String password) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                userLiveData.postValue(mAuth.getCurrentUser());
                                Toast.makeText(application.getApplicationContext(),"Kayıt Başarıyla oluşturuldu. ",Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(application.getApplicationContext(), "Registration Failure: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    //If user want to quit from system, this func will use.
    public void logOut() {
        mAuth.signOut();
        loggedOutLiveData.postValue(true);
    }

    //Returns the userlivedata value, it will use another layers.
    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    //Returns the logged out logic value, it will use another layers.
    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }



}
