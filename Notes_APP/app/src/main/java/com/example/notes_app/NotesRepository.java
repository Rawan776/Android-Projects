package com.example.notes_app;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepository {
    private NotesDAO noteDao;
    private LiveData<List<NotesEntity>> allNotes;

    public NotesRepository(Application application) {
        NotesDatabase notesDatabase=NotesDatabase.getInstance(application);
        this.noteDao = notesDatabase.notesDAO();
        this.allNotes = noteDao.getAllNotes();
    }

    public void insert(NotesEntity note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(NotesEntity note) {
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(NotesEntity note) {
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<NotesEntity>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<NotesEntity, Void, Void> {
        private NotesDAO noteDao;

        private InsertNoteAsyncTask(NotesDAO noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NotesEntity... notes) {
            noteDao.insertNotes(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<NotesEntity, Void, Void> {
        private NotesDAO noteDao;

        private UpdateNoteAsyncTask(NotesDAO noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NotesEntity... notes) {
            noteDao.Update_note(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<NotesEntity, Void, Void> {
        private NotesDAO noteDao;

        private DeleteNoteAsyncTask(NotesDAO noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NotesEntity... notes) {
            noteDao.deleteNote(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private NotesDAO noteDao;

        private DeleteAllNotesAsyncTask(NotesDAO noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.DeleteAllNotes();
            return null;
        }
    }
}
