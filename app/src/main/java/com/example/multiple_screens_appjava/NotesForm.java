package com.example.multiple_screens_appjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotesForm extends AppCompatActivity {

    EditText titleEditText;
    EditText notesEditText;
    EditText additionalNotesEditText;
    Button saveButton;
    Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        titleEditText = findViewById(R.id.titleEditText);
        notesEditText = findViewById(R.id.notesEditText);
        additionalNotesEditText = findViewById(R.id.additionalNotesEditText);
        saveButton = findViewById(R.id.saveButton);
        clearButton = findViewById(R.id.clearButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNotes();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();
            }
        });
    }

    private void saveNotes() {
        String title = titleEditText.getText().toString().trim();
        String notes = notesEditText.getText().toString().trim();
        String additionalNotes = additionalNotesEditText.getText().toString().trim();

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(notes)) {
            Toast.makeText(this, "Please enter title and notes!", Toast.LENGTH_SHORT).show();
        } else {
            // Save the notes and additional notes to your desired storage or perform any other actions
            String allNotes = notes + "\nAdditional Notes: " + additionalNotes;
            Toast.makeText(this, "Notes saved!\n\n" + allNotes, Toast.LENGTH_SHORT).show();
            clearFields();
        }
    }

    private void clearFields() {
        titleEditText.setText("");
        notesEditText.setText("");
        additionalNotesEditText.setText("");
    }
}
