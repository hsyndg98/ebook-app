package com.example.ebookapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ebookapp.LocalDB.model.BookModel;
import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentHomePageBinding;
import com.example.ebookapp.viewmodel.BookViewModel;
import com.example.ebookapp.viewmodel.Category;
import com.example.ebookapp.viewmodel.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment {
    private RecyclerView rv;
    private HomeAdapter adapter;
    private FragmentHomePageBinding binding;
    private BookViewModel bookViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("GELDİFRAGMENT","Activity geldi");

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();


        List<BookModel> thriller = new ArrayList<>();
        //Log.e("KİTAPLİST","Size "+bookViewModel.getBookLiveData().getValue().size());
        //bookViewModel.getBookLiveData().observe(new Observer<>(){

        //});
        for(BookModel book: bookViewModel.getBookList()){
            thriller.add(book);
        }


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