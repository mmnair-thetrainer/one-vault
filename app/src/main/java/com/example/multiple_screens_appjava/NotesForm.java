package com.example.multiple_screens_appjava;

import android.content.Intent;
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
    Button backButton;  // Define the backButton button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        titleEditText = findViewById(R.id.titleEditText);
        notesEditText = findViewById(R.id.notesEditText);
        additionalNotesEditText = findViewById(R.id.additionalNotesEditText);
        saveButton = findViewById(R.id.saveButton);
        clearButton = findViewById(R.id.clearButton);
        backButton = findViewById(R.id.backButton); // Initialize the backButton button

        saveButton.setOnClickListener(view -> saveNotes());

        clearButton.setOnClickListener(view -> clearFields());

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(NotesForm.this, FeaturesDashboard.class);
            startActivity(intent);
        });
    }

    private void saveNotes() {
        // Your existing code for saving notes
    }

    private void clearFields() {
        titleEditText.setText("");
        notesEditText.setText("");
        additionalNotesEditText.setText("");
    }
}
