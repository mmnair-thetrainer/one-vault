package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordInheritance extends AppCompatActivity {

    EditText entriesEditText;
    EditText inheritFromEditText;
    EditText inheritToEditText;
    Button inheritButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordinheritance);

        entriesEditText = findViewById(R.id.entriesEditText);
        inheritFromEditText = findViewById(R.id.inheritFromEditText);
        inheritToEditText = findViewById(R.id.inheritToEditText);
        inheritButton = findViewById(R.id.inheritButton);

        inheritButton.setOnClickListener(view -> inheritPassword());
    }

    private void inheritPassword() {
        String entries = entriesEditText.getText().toString().trim();
        String inheritFrom = inheritFromEditText.getText().toString().trim();
        String inheritTo = inheritToEditText.getText().toString().trim();

        Intent intent = new Intent(PasswordInheritance.this, FeaturesDashboard.class);
        startActivity(intent);

        // Perform the inheritance operation here, or any other actions based on the form data
        // For demonstration purposes, we'll just display a toast message with the form data.
        String message = "Inherit Password: " + inheritFrom + " to " + inheritTo +
                " for the entries: " + entries;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
