package com.example.ebookapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ebookapp.data.model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class EbookDatabase extends RoomDatabase {
    private static volatile EbookDatabase INSTANCE;

    public abstract UserDao userDao();


    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static EbookDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EbookDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EbookDatabase.class, "ebookdatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
