package com.example.ebookapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebookapp.LocalDB.model.BookModel;
import com.example.ebookapp.databinding.FragmentHomePageBinding;
import com.example.ebookapp.viewmodel.BookViewModel;
import com.example.ebookapp.viewmodel.Category;
import com.example.ebookapp.viewmodel.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment {
    List<BookModel> thriller = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    private RecyclerView rv;
    private HomeAdapter adapter;
    private FragmentHomePageBinding binding;
    private BookViewModel bookViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        thriller.addAll(bookViewModel.getBookList());


        categoryList.add(new Category("Okumaya Devam Et", thriller));
        categoryList.add(new Category("Senin İçin Önerilenler", thriller));


        setViews(categoryList);


        return view;

    }

    private void setViews(List<Category> categoryList) {
        rv = binding.rvHome;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        adapter = new HomeAdapter(getContext(), categoryList);
        rv.setAdapter(adapter);
    }
}