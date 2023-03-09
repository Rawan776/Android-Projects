package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes_app.Adapter.Notes_Adapter;
import com.example.notes_app.databinding.ActivityMainBinding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NotesViewModel noteViewModel;
    private ActivityMainBinding binding;
    private Notes_Adapter notes_adapter;
    private Bundle notes_bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //floatingbutton
        binding.buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,Add_note_activity.class);
                startActivity(i);
            }
        });

        //bind recycleview
        //best practice as it easier to use variable instead of using (binding.NotesRV) every time
        RecyclerView recyclerView=binding.NotesRV;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //viewModel
        noteViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        //not passing context
        notes_adapter=new Notes_Adapter(getApplicationContext());
        recyclerView.setAdapter(notes_adapter);
        GetAllNotes();


    }
    private void GetAllNotes(){
        noteViewModel.getAllNotes().observe(this, new Observer<List<NotesEntity>>() {
            @Override
            public void onChanged(List<NotesEntity> notesEntities) {
                //update RecyclerView
               // update_note_list();
                notes_adapter.setNotesitemList((ArrayList<NotesEntity>) notesEntities);
            }
        });
    }

    private void update_note_list(){
        notes_bundle=new Bundle();
        notes_bundle=getIntent().getExtras();
        if(notes_bundle!=null){
            String title= notes_bundle.getString("title");
            String description =notes_bundle.getString("Description");
            int priority=notes_bundle.getInt("priority");

            NotesEntity notes=new NotesEntity(title,description,priority);
            noteViewModel.insert(notes);
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show();

    }

}