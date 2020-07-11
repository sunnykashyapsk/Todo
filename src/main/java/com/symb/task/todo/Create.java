package com.symb.task.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {
    private Button b1;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        b1=findViewById(R.id.save);
        editText=findViewById(R.id.input);

        final DatabaseHelper helper = new DatabaseHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    if (helper.insertt(text)) {
                        editText.setText("");
                        Toast.makeText(Create.this, "Inserted", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Create.this, "NOT Inserted", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}
