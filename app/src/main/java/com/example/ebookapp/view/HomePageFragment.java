package com.example.ebookapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebookapp.databinding.FragmentHomePageBinding;
import com.example.ebookapp.viewmodel.HomePageViewModel;
import com.google.firebase.auth.FirebaseUser;

public class HomePageFragment extends Fragment {
    private TextView loggedInUserTextView;
    private Button logOutButton;

    private FragmentHomePageBinding binding;
    private HomePageViewModel homePageViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePageViewModel = new ViewModelProvider(this).get(HomePageViewModel.class);

        homePageViewModel.getUserLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    loggedInUserTextView.setText("Logged In User: " + firebaseUser.getEmail());
                    logOutButton.setEnabled(true);
                } else {
                    logOutButton.setEnabled(false);
                }
            }
        });

        homePageViewModel.getLoggedOutLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean loggedOut) {
                if (loggedOut) {
                    Toast.makeText(getContext(), "User Logged Out", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(getView()).navigate(R.id.action_homePageFragment_to_loginFragment);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        loggedInUserTextView = binding.tvYazi;
        logOutButton = binding.button;

        homePageViewModel.getUserLiveData().observe(getViewLifecycleOwner(), firebaseUser ->
                {
                    binding.tvYazi.setText(firebaseUser.getEmail().toString());
                }
        );

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePageViewModel.logOut();
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