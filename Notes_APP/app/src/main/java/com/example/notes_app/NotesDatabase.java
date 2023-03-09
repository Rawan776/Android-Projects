package com.example.notes_app;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import kotlin.jvm.Synchronized;

@Database(entities = {NotesEntity.class},version = 1,exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {
    private static NotesDatabase Instance;
    public abstract NotesDAO notesDAO();
    public static synchronized NotesDatabase getInstance(Context context) {
        if(Instance==null){
            Instance= Room.databaseBuilder(context.getApplicationContext(),NotesDatabase.class,"Notes_DB")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return Instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(Instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private NotesDAO noteDao;

        private PopulateDbAsyncTask(NotesDatabase db) {
            noteDao = db.notesDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insertNotes(new NotesEntity("Title 1", "Description 1", 1));
            noteDao.insertNotes(new NotesEntity("Title 2", "Description 2", 2));
            noteDao.insertNotes(new NotesEntity("Title 3", "Description 3", 3));
            return null;
        }
    }

}
