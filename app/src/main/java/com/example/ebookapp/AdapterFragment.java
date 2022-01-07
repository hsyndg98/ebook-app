package com.example.ebookapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ebookapp.view.HomeActivity;


public class AdapterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        startActivity(new Intent(getContext(), HomeActivity.class));

        return inflater.inflate(R.layout.fragment_adapter, container, false);
    }
}