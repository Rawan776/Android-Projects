package com.example.notes_app;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesViewModel extends AndroidViewModel  {
    private NotesRepository notesRepository;
    private LiveData<List<NotesEntity>> allNotes;


    public NotesViewModel(@NonNull Application application) {
        super(application);
        notesRepository=new NotesRepository(application);
        allNotes=notesRepository.getAllNotes();
    }
    public void insert(NotesEntity note) {
        notesRepository.insert(note);
    }

    public void update(NotesEntity note) {
        notesRepository.update(note);
    }

    public void delete(NotesEntity note) {
        notesRepository.delete(note);
    }

    public void deleteAllNotes() {
        notesRepository.deleteAllNotes();
    }

    public LiveData<List<NotesEntity>> getAllNotes() {
        return allNotes;
    }
}
