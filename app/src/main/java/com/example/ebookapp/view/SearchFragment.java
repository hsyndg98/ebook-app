package com.example.ebookapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentLoginBinding;
import com.example.ebookapp.databinding.FragmentSearchBinding;
import com.example.ebookapp.viewmodel.Book;
import com.example.ebookapp.viewmodel.Category;
import com.example.ebookapp.viewmodel.HomeAdapter;
import com.example.ebookapp.viewmodel.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private RecyclerView rv;
    private SearchAdapter adapter;
    private FragmentSearchBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        List<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book(1,R.drawable.kuzularinsesizligi,"Kuzuların Sessizliği","Elif Akay"));
        allBooks.add(new Book(2,R.drawable.kuzularinsesizligi, "Otomatik Portokal","Fatih İzgi"));
        allBooks.add(new Book(3,R.drawable.kuzularinsesizligi,"Küçük Prens Sessizliği","Elif Akay"));
        allBooks.add(new Book(4,R.drawable.kuzularinsesizligi, "Dönüşüm","Elif Akay"));

        binding.rvResults.setHasFixedSize(true);
        binding.rvResults.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));


        binding.buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isBook = binding.rbBook.isChecked();
                boolean isAuthor = binding.rbAuthor.isChecked();
                boolean isId = binding.rbId.isChecked();


                if(isBook){
                    ArrayList<Book> books = new ArrayList<>();



                    for(Book book : allBooks){

                        if(binding.editTextEntered.getText().toString().equals(book.getBookName())){
                            books.add(book);
                        }
                    }
                    binding.tvResultMessage.setText("Girilen isme ait kitaplar : ");
                    adapter = new SearchAdapter(getContext(),books);
                    binding.rvResults.setAdapter(adapter);

                }
                if(isAuthor){
                    ArrayList<Book> books = new ArrayList<>();

                    for(Book book : allBooks){

                        if(binding.editTextEntered.getText().toString().equals(book.getAuthor())){
                            books.add(book);
                        }
                    }
                    binding.tvResultMessage.setText("Girilen yazara ait kitaplar : ");
                    adapter = new SearchAdapter(getContext(),books);
                    binding.rvResults.setAdapter(adapter);
                }
                if(isId){
                    ArrayList<Book> books = new ArrayList<>();

                    for(Book book : allBooks){

                        if(binding.editTextEntered.getText().toString().equals(String.valueOf(book.getId()))){

                            books.add(book);
                        }
                    }

                    binding.tvResultMessage.setText("Girilen ISBN'ye ait kitaplar : ");

                    adapter = new SearchAdapter(getContext(),books);
                    binding.rvResults.setAdapter(adapter);
                }
                if(!isBook && !isAuthor && !isId){
                    Toast.makeText(getContext(),"Lütfen bir arama kriteri seçin",Toast.LENGTH_SHORT).show();
                }

            }
        });






        return view;

    }
}