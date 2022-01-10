package com.example.ebookapp.viewmodel;

import android.app.Application;
import android.app.ProgressDialog;

import androidx.lifecycle.AndroidViewModel;

import com.example.ebookapp.LocalDB.model.BookModel;
import com.example.ebookapp.RemoteDB.FirebaseBook;

import java.util.List;

public class BookViewModel extends AndroidViewModel {

    private FirebaseBook fBook;

    public BookViewModel(Application application){
        super(application);

        fBook = new FirebaseBook(application);
    }

    public void getAllBooks(){ fBook.getAllBooks();}


    public List<BookModel> getBookList(){ return fBook.getBookList();}

    public void dowloadBooktoLocal(String firebaseDir,ProgressDialog pd, BookModel bookModel ){ fBook.downloadBooktoLocal(firebaseDir,pd,bookModel);}

}
