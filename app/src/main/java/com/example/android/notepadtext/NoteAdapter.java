package com.example.android.notepadtext;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> myNoteList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView NoteName;

        public ViewHolder(View view){
            super(view);
            NoteName = view.findViewById(R.id.note_message);
        }
    }

    public void addNote(Note Note){
        myNoteList.add(Note);
        notifyItemInserted(0);
    }

    public NoteAdapter(List<Note> NoteList){
        myNoteList = NoteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note Note = myNoteList.get(position);
        holder.NoteName.setText(Note.getMessage());
    }

    @Override
    public int getItemCount() {
        return myNoteList.size();
    }
}


