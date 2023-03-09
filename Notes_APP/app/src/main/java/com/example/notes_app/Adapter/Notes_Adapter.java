package com.example.notes_app.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes_app.NotesEntity;
import com.example.notes_app.R;
import com.example.notes_app.databinding.NotesLayoutBinding;

import java.util.ArrayList;

public class Notes_Adapter extends RecyclerView.Adapter<Notes_Adapter.NotesViewHolder>{
    private ArrayList <NotesEntity>NotesitemList;
    private  Context context;

    public Notes_Adapter(Context context) {
        this.context=context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setNotesitemList(ArrayList<NotesEntity> notesitemList) {
        NotesitemList = notesitemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override


    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NotesLayoutBinding notesLayoutBinding=DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()), R.layout.notes_layout,null,false);
        return new NotesViewHolder(notesLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        //mapping view in layout.xml
        //holder.noteslayoutBinding.title_TXT.setText(NotesitemList.get(position).gettitle())
        //instead of
        NotesEntity notesEntity=NotesitemList.get(position);
        holder.noteslayoutBinding.setNoteObj(notesEntity);
    }

    @Override
    public int getItemCount() {
        //most important here if using view model
        if(NotesitemList!=null)
            return NotesitemList.size();
        else
            return 0;
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder {
        NotesLayoutBinding noteslayoutBinding;
        public NotesViewHolder(@NonNull NotesLayoutBinding noteslayoutBinding ) {
            super(noteslayoutBinding.getRoot());
            this.noteslayoutBinding=noteslayoutBinding;


        }
    }
}
