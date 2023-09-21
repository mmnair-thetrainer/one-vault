package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText address;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        register.setOnClickListener(view -> {
            if (checkDataEntered()) {
                moveToLoginPage();
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
        if (isEmpty(firstName)) {
            Toast t = Toast.makeText(this, "You must enter a first name to register!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(lastName)) {
            lastName.setError("Last name is required!");
            return false;
        }

        if (!isEmail(email)) {
            email.setError("Enter a valid email!");
            return false;
        }

        return true;
    }

    void moveToLoginPage() {
        Intent intent = new Intent(MainActivity.this, LoginPage.class);
        startActivity(intent);
    }
}
