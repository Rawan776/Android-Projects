package com.example.notes_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.notes_app.databinding.ActivityAddNoteBinding;

public class Add_note_activity extends AppCompatActivity {
    private ActivityAddNoteBinding addNoteBinding;
    private NotesViewModel noteViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addNoteBinding= DataBindingUtil.setContentView(this,R.layout.activity_add_note);
         NumberPicker numberPickerPriority=addNoteBinding.numberPickerPriority;
         numberPickerPriority.setMinValue(1);
         numberPickerPriority.setMaxValue(5);

         addNoteBinding.saveButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 save_note();
                 Intent i =new Intent(Add_note_activity.this,MainActivity.class);
                 startActivity(i);
             }
         });
    }
    private void save_note(){
        String Title=addNoteBinding.editTextTitle.getText().toString();
        String Description =addNoteBinding.editTextDescription.getText().toString();
        int priority=addNoteBinding.numberPickerPriority.getValue();

        if (Title.trim().isEmpty() || Description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            NotesEntity notes=new NotesEntity(Title,Description,priority);
            noteViewModel=new ViewModelProvider(this).get(NotesViewModel.class);
            noteViewModel.insert(notes);
            Toast.makeText(this, "Note saved", Toast.LENGTH_LONG).show();
        }
//         Intent data = Intent(Add_note_activity.this,MainActivity.class);
//         data.putExtra("title",Title);
//         data.putExtra("Description",Description);
//         data.putExtra("priority",priority);


    }
}