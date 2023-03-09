package com.example.notes_app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDAO {

    @Insert
    void insertNotes(NotesEntity notes);
    @Delete
    void deleteNote(NotesEntity notes);
    @Update
    void Update_note(NotesEntity notes);
    @Query("DELETE FROM notes_table")
    void DeleteAllNotes();
    @Query("SELECT * FROM notes_table ORDER BY priority DESC")
    LiveData<List<NotesEntity>> getAllNotes();
}
