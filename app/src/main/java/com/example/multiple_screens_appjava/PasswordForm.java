package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordForm extends AppCompatActivity {

    EditText urlEditText;
    EditText userNameEditText;
    EditText passwordEditText;
    Button saveButton;
    Button clearButton;
    Button backButton;  // Define the backButton button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        urlEditText = findViewById(R.id.urlEditText);
        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        saveButton = findViewById(R.id.saveButton);
        clearButton = findViewById(R.id.clearButton);
        backButton = findViewById(R.id.backButton); // Initialize the backButton button

        saveButton.setOnClickListener(view -> savePassword());

        clearButton.setOnClickListener(view -> clearFields());

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(PasswordForm.this, DashboardActivity.class);
            startActivity(intent);
        });
    }

    private void savePassword() {
        // Your existing code for saving the password
    }

    private void clearFields() {
        urlEditText.setText("");
        userNameEditText.setText("");
        passwordEditText.setText("");
    }
}
