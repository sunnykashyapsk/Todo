package com.symb.task.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Todo extends AppCompatActivity {
    private ListView listView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        final DatabaseHelper helper = new DatabaseHelper(this);
        final ArrayList array_list = helper.getAll();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(Todo.this,android.R.layout.simple_list_item_1, array_list);
        listView = findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        button = findViewById(R.id.refresh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array_list.clear();
                array_list.addAll(helper.getAll());
                arrayAdapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }
        });

    }
}
