package com.example.ebookapp.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ebookapp.LocalDB.DB.Book;
import com.example.ebookapp.LocalDB.DB.BooksInRoom;
import com.example.ebookapp.LocalDB.model.BookModel;
import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentHomePageBinding;
import com.example.ebookapp.databinding.FragmentLibraryBinding;
import com.example.ebookapp.viewmodel.SearchAdapter;
import com.example.ebookapp.viewmodel.SearchAdapterLibrary;

import java.util.ArrayList;
import java.util.List;


public class LibraryFragment extends Fragment {

    private FragmentLibraryBinding binding;
    private SearchAdapterLibrary adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentLibraryBinding.inflate(inflater,container,false);
        View view = binding.getRoot();



        binding.rvCurrentlyReading.setHasFixedSize(true);
        binding.rvCurrentlyReading.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        adapter = new SearchAdapterLibrary(getContext(), BooksInRoom.booksInRoom);
        binding.rvCurrentlyReading.setAdapter(adapter);

        binding.rvDownloaded.setHasFixedSize(true);
        binding.rvDownloaded.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        adapter = new SearchAdapterLibrary(getContext(), BooksInRoom.booksInRoom);
        binding.rvDownloaded.setAdapter(adapter);

        return view;
    }


}