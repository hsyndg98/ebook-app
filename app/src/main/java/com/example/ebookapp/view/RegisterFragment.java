package com.example.ebookapp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentRegisterBinding;
import com.example.ebookapp.viewmodel.RegisterViewModel;
import com.google.firebase.auth.FirebaseUser;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private RegisterViewModel registerViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.etName.getText().toString().trim();
                String email = binding.etEmail.getText().toString().trim();
                String password = binding.etPassword.getText().toString().trim();
                String rePassword = binding.etRepassword.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(getContext(),"Lütfen adınızı giriniz",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getContext(),"Lütfen emailinizi giriniz",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getContext(),"Lütfen parolanızı giriniz",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(rePassword)){
                    Toast.makeText(getContext(),"Lütfen parolanızı giriniz",Toast.LENGTH_SHORT).show();

                }
                if(!password.equals(rePassword)){
                    Toast.makeText(getContext(),"Parolanız eşleşmiyor.",Toast.LENGTH_SHORT).show();

                }

                if (email.length() > 0 && password.length() > 0) {
                    registerViewModel.register(email, password);
                    Navigation.findNavController(getView()).navigate(R.id.action_registerFragment_to_loginFragment);

                } else {
                    Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.imgToLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_registerFragment_to_loginFragment);
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