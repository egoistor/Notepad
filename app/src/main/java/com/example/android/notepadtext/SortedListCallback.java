package com.example.android.notepadtext;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;

public class SortedListCallback extends SortedListAdapterCallback<Note> {

    public SortedListCallback(RecyclerView.Adapter adapter) {
        super(adapter);
    }

    @Override
    public void onRemoved(int position, int count) {
        super.onRemoved(position, count);
    }

    @Override
    public int compare(Note note, Note t21) {
        return 0;
    }

    @Override
    public void onMoved(int fromPosition, int toPosition) {
        super.onMoved(fromPosition, toPosition);
    }

    @Override
    public void onChanged(int position, int count, Object payload) {
        super.onChanged(position, count, payload);
    }

    @Override
    public void onInserted(int position, int count) {
        super.onInserted(position, count);
    }

    @Override
    public void onChanged(int position, int count) {
        super.onChanged(position, count);
    }
}
