package com.example.android.notepadtext;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Note> noteList = new ArrayList<>();
    private SortedList<Note> mDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        Button edit = findViewById(R.id.goEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, EditActivity.class );
                startActivity(intent1);
            }
        });

        Button delete = findViewById(R.id.goDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent2);
            }
        });


        final RecyclerView recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final NoteAdapter adapter = new NoteAdapter(noteList);
        mDataList = new SortedList<>(Note.class, new NoteListCallback(adapter));
        mDataList.beginBatchedUpdates();
        mDataList.endBatchedUpdates();
        recyclerView.setAdapter(adapter);

        Note note = (Note) getIntent().getSerializableExtra("newNote");
        mDataList.beginBatchedUpdates();
        mDataList.add(note);
        mDataList.endBatchedUpdates();
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
