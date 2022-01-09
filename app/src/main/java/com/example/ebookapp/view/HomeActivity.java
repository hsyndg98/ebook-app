package com.example.ebookapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.example.ebookapp.R;
import com.example.ebookapp.viewmodel.BookViewModel;
import com.example.ebookapp.viewmodel.RegisterViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private static boolean a = false;
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("GELDİACTİVİTY","Activity geldi");

        //Firebaseten tüm kitapları almak için kullanılır.
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getAllBooks();

        setContentView(R.layout.activity_home);

        bottomNav = findViewById(R.id.bottomNav);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentCV);

        NavigationUI.setupWithNavController(bottomNav,navHostFragment.getNavController());

    }

    @Override
    public void onBackPressed() {
        if(a){
            super.onBackPressed();
        }else{}
    }
}