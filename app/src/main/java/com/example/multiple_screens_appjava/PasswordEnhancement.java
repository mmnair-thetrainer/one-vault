package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordEnhancement extends AppCompatActivity {

    EditText passwordLengthEditText;
    Spinner passwordComplexitySpinner;
    EditText capsCountEditText;
    EditText specialCharacterCountEditText;
    EditText numericValueCountEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordenhancement);

        // Find the views by their IDs
        passwordLengthEditText = findViewById(R.id.passwordLengthEditText);
        passwordComplexitySpinner = findViewById(R.id.passwordComplexitySpinner);
        capsCountEditText = findViewById(R.id.capsCountEditText);
        specialCharacterCountEditText = findViewById(R.id.specialCharacterCountEditText);
        numericValueCountEditText = findViewById(R.id.numericValueCountEditText);
        saveButton = findViewById(R.id.saveButton);

        // Set the click listener for the save button
        saveButton.setOnClickListener(view -> saveForm());
    }


    private void saveForm() {
        String passwordLength = passwordLengthEditText.getText().toString().trim();
        String passwordComplexity = passwordComplexitySpinner.getSelectedItem().toString();
        String capsCount = capsCountEditText.getText().toString().trim();
        String specialCharacterCount = specialCharacterCountEditText.getText().toString().trim();
        String numericValueCount = numericValueCountEditText.getText().toString().trim();

        // Perform the save operation here
        // For demonstration purposes, we'll just display a toast message indicating the form is saved.
        Intent intent = new Intent(PasswordEnhancement.this, FeaturesDashboard.class);
        startActivity(intent);

        String formData = "Password Length: " + passwordLength + "\n" +
                "Password Complexity: " + passwordComplexity + "\n" +
                "Caps Count: " + capsCount + "\n" +
                "Special Character Count: " + specialCharacterCount + "\n" +
                "Numeric Value Count: " + numericValueCount;

        Toast.makeText(this, "Form Data Saved:\n\n" + formData, Toast.LENGTH_LONG).show();
    }
}
