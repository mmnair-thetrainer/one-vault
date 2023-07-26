package com.example.multiple_screens_appjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    EditText email; // Add this line to declare the email field
    Button register;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        country = findViewById(R.id.country);
        dateOfBirth = findViewById(R.id.dateOfBirth);
        email = findViewById(R.id.email); // Initialize the email field
        register = findViewById(R.id.register);

        register.setOnClickListener(view -> {
            if (checkDataEntered()) {
                // Data is valid, navigate to the login page
                Intent loginIntent = new Intent(Registration.this, LoginPage.class);
                startActivity(loginIntent);
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
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
