package com.example.ebookapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentHomePageBinding;
import com.example.ebookapp.databinding.FragmentRegisterBinding;
import com.example.ebookapp.viewmodel.Book;
import com.example.ebookapp.viewmodel.Category;
import com.example.ebookapp.viewmodel.HomeAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment {
    private RecyclerView rv;
    private HomeAdapter adapter;
    private FragmentHomePageBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.homePageNavigation:
                        // Switch to page one
                        Navigation.findNavController(getView()).navigate(R.id.homePageNavigation);
                        break;
                    case R.id.searchFragment:
                        Navigation.findNavController(getView()).navigate(R.id.searchFragment);
                        break;
                    case R.id.libraryFragment:
                        Navigation.findNavController(getView()).navigate(R.id.libraryFragment);
                        break;
                    case R.id.accountFragment:
                        Navigation.findNavController(getView()).navigate(R.id.accountFragment);
                        break;

                }

                return true;
                }

        });



                List<Book> thriller = new ArrayList<>();
        thriller.add(new Book(1,R.drawable.kuzularinsesizligi,"Kuzuların Sessizliği"));
        thriller.add(new Book(2,R.drawable.kuzularinsesizligi, "Otomatik Portokal"));
        thriller.add(new Book(1,R.drawable.kuzularinsesizligi,"Kuzuların Sessizliği"));
        thriller.add(new Book(2,R.drawable.kuzularinsesizligi, "Otomatik Portokal"));
        thriller.add(new Book(1,R.drawable.kuzularinsesizligi,"Kuzuların Sessizliği"));
        thriller.add(new Book(2,R.drawable.kuzularinsesizligi, "Otomatik Portokal"));


        List<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category("Okumaya Devam Et",thriller));
        categoryList.add(new Category("Senin İçin Önerilenler",thriller));
        categoryList.add(new Category("Okumaya Devam Et",thriller));
        categoryList.add(new Category("Senin İçin Önerilenler",thriller));
        categoryList.add(new Category("Okumaya Devam Et",thriller));
        categoryList.add(new Category("Senin İçin Önerilenler",thriller));

        setViews(categoryList);

        return view;

    }

    private void setViews(List<Category> categoryList){
        rv = binding.rvHome;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        rv.setLayoutManager(layoutManager);
        adapter = new HomeAdapter(getContext(),categoryList);
        rv.setAdapter(adapter);
    }
}