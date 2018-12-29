package com.example.android.notepadtext;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity {
    private List<Note> deleteNoteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        final RecyclerView recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final NoteAdapter adapter = new NoteAdapter(deleteNoteList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //TODO
            }
        });

        adapter.setOnItemLongClickListener(new NoteAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                //TODO
            }
        });
        recyclerView.setAdapter(adapter);
    }


}
