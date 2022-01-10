package com.example.ebookapp.view;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ebookapp.LocalDB.DB.Book;
import com.example.ebookapp.LocalDB.DB.BooksInRoom;
import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentReadingBinding;
import com.example.ebookapp.databinding.FragmentRegisterBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFragment extends Fragment {

    private Book bookLocal;
    private FragmentReadingBinding binding;
    private String book;
    private BottomNavigationView navBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String bookName = getArguments().getString("bookName");

        for(Book book: BooksInRoom.booksInRoom){

            if(book.getBookName().equals(bookName)) bookLocal = book;
        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Displaying the user details on the screen

    }

    public String getFileText() throws IOException {

        File file = new File(bookLocal.getFileAdress()); //saves in Android/
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

        } finally {
            br.close();
        }
        return sb.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReadingBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        //Async ile yapılabilir kitap yerel cihazdan alınıp textview içinde gösteriliyor.
        try {
            binding.tvBook.setText(getFileText());
            binding.tvBook.setMovementMethod(new ScrollingMovementMethod());
        } catch (IOException e) {
            e.printStackTrace();
        }


        binding.toolbarReading.setTitle(bookLocal.getBookName());
        binding.toolbarReading.setNavigationOnClickListener(task ->{
            navBar = getActivity().findViewById(R.id.bottomNav);
            navBar.setVisibility(View.VISIBLE);
            Navigation.findNavController(getView()).navigate(R.id.action_readingFragment_to_homePageFragment);

        });


        return view;
    }

}