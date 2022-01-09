package com.example.ebookapp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentLoginBinding;
import com.example.ebookapp.viewmodel.LoginViewModel;
import com.google.firebase.auth.FirebaseUser;


public class LoginFragment extends Fragment {

    private LoginViewModel mLoginViewModel;
    private FragmentLoginBinding binding;
    private FirebaseUser fUser;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        Log.e("MESAJ","Registeedan diretk buraya geldi");

        mLoginViewModel.getUserLiveData().observe(this, firebaseUser -> {
            if (firebaseUser != null) {
                Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_homePageFragment);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.imgToReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_registerFragment2);
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.etEmail.getText().toString().trim();

                String password = binding.etPassword.getText().toString().trim();
                if (email.length() > 0 && password.length() > 0) {
                    mLoginViewModel.login(email, password);

                } else {
                    Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}