package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText country;
    EditText dateOfBirth;
    EditText email;
    Button register;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        country = findViewById(R.id.country);
        dateOfBirth = findViewById(R.id.dateOfBirth);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);
        back = findViewById(R.id.back);

        // Initially, disable the "Register" button
        register.setEnabled(true);

        register.setOnClickListener(view -> {
            if (checkDataEntered()) {
                // Data is valid, navigate to the login page
                Intent loginPageIntent = new Intent(Registration.this, MasterPasswordCreation.class);
                startActivity(loginPageIntent);
            }
        });

        // Add a click listener for the "Back" button
        back.setOnClickListener(view -> {
            // Handle navigation back to the previous activity (e.g., FeaturesDashboard)
            Intent backIntent = new Intent(Registration.this, FeaturesDashboard.class);
            startActivity(backIntent);
        });

        // Add text change listeners to the EditText fields to enable/disable the "Register" button
        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        country.addTextChangedListener(textWatcher);
        dateOfBirth.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Check if all EditText fields are not empty and email is valid
            boolean isAllFieldsValid = !isEmpty(username) &&
                    !isEmpty(password) &&
                    !isEmpty(country) &&
                    !isEmpty(dateOfBirth) &&
                    isEmail(email);

            // Enable or disable the "Register" button based on the validation result
            register.setEnabled(isAllFieldsValid);
        }
    };

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean checkDataEntered() {
        boolean isValid = true;

        if (isEmpty(username)) {
            Toast.makeText(this, "You must enter a username to register!", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        if (isEmpty(password)) {
            password.setError("Password is required!");
            isValid = false;
        }

        if (isEmpty(country)) {
            country.setError("Country is required!");
            isValid = false;
        }

        if (isEmpty(dateOfBirth)) {
            dateOfBirth.setError("Date of birth is required!");
            isValid = false;
        }

        if (!isEmail(email)) {
            email.setError("Enter a valid email!");
            isValid = false;
        }

        return isValid;
    }
}
