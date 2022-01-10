package com.example.ebookapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ebookapp.R;
import com.example.ebookapp.databinding.FragmentListeningBinding;


public class ListeningFragment extends Fragment {

    private FragmentListeningBinding binding;
    private String bookImageURL;
    private String bookName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListeningBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        bookImageURL = getArguments().getString("bookImage");
        bookName = getArguments().getString("bookName");

        binding.tvBookName.setText(bookName);

        Glide.with(getContext()).load(bookImageURL).into(binding.imageViewBookPhoto);


        binding.toolbarListening.setTitle(bookName);
        binding.toolbarListening.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_listeningFragment_to_homePageFragment);
            }
        });

        binding.imgListenBook.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Book is listening...",Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }
}