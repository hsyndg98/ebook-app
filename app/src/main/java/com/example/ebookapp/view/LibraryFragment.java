package com.example.ebookapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentHomePageBinding;
import com.example.ebookapp.databinding.FragmentLibraryBinding;
import com.example.ebookapp.viewmodel.SearchAdapter;

import java.util.ArrayList;
import java.util.List;


public class LibraryFragment extends Fragment {

    /*private FragmentLibraryBinding binding;
    private SearchAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentLibraryBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        List<Book> books = new ArrayList<>();
        books.add(new Book(1,R.drawable.kuzularinsesizligi,"Kuzuların Sessizliği","Elif Akay"));
        books.add(new Book(2,R.drawable.kuzularinsesizligi, "Otomatik Portokal","Fatih İzgi"));
        books.add(new Book(3,R.drawable.kuzularinsesizligi,"Küçük Prens Sessizliği","Elif Akay"));
        books.add(new Book(4,R.drawable.kuzularinsesizligi, "Dönüşüm","Elif Akay"));

        binding.rvCurrentlyReading.setHasFixedSize(true);
        binding.rvCurrentlyReading.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        adapter = new SearchAdapter(getContext(),books);
        binding.rvCurrentlyReading.setAdapter(adapter);

        binding.rvDownloaded.setHasFixedSize(true);
        binding.rvDownloaded.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        adapter = new SearchAdapter(getContext(),books);
        binding.rvDownloaded.setAdapter(adapter);

        return view;
    }*/
}