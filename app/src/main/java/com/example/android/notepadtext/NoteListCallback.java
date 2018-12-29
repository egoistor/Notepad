package com.example.android.notepadtext;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;

public class NoteListCallback extends SortedListAdapterCallback<Note> {

    public NoteListCallback(RecyclerView.Adapter adapter) {
        super(adapter);
    }

    @Override
    public int compare(Note o1, Note o2) {
        //TODO:
        return 0;
    }

    @Override
    public boolean areContentsTheSame(Note oldItem, Note newItem) {
        //TODO:
        return false;
    }

    @Override
    public boolean areItemsTheSame(Note item1, Note item2) {
        return false;
    }

}
