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

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    private List<Note> myNoteList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView NoteName;
        TextView TimeShow;

        public ViewHolder(View view){
            super(view);
            NoteName = view.findViewById(R.id.note_message);
            TimeShow = view.findViewById(R.id.time_shows);
        }
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

    public void onBindViewHolder(final ViewHolder holder, int position) {

        Note Note = myNoteList.get(position);
        holder.NoteName.setText(Note.getMessage());
        holder.TimeShow.setText(Note.getYear()+"/"+Note.getMonth()+"/"+Note.getDay());

        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                }

            });
        }
        if(mOnItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                    return true;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return myNoteList.size();
    }
}


