package com.example.ebookapp.RemoteDB;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookapp.LocalDB.model.BookModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class FirebaseBook {

    private FirebaseDatabase mRealtimeDatabase;
    private FirebaseStorage mStorage;
    private static List<BookModel> bookList = new ArrayList<>();

    public FirebaseBook(Application application){

        mRealtimeDatabase = FirebaseDatabase.getInstance();
        mStorage = FirebaseStorage.getInstance();


    }

    //This function takes all books' properties from realtime db.
    public void getAllBooks(){

        DatabaseReference mRealtimeRef = mRealtimeDatabase.getReference();

        mRealtimeRef.child("books").get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            }
            else {
                for(DataSnapshot ds: task.getResult().getChildren()){

                    BookModel book = ds.getValue(BookModel.class);

                    bookList.add(book);
                }
            }
        });

    }

    public List<BookModel> getBookList(){
        return bookList;
    }

}
