package com.example.multiple_screens_appjava;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        urlEditText = findViewById(R.id.urlEditText);
        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        saveButton = findViewById(R.id.saveButton);
        clearButton = findViewById(R.id.clearButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePassword();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();
            }
        });
    }

    private void savePassword() {
        String url = urlEditText.getText().toString().trim();
        String userName = userNameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill in all password details!", Toast.LENGTH_SHORT).show();
        } else {
            // Save the password to your desired storage or perform any other actions
            String fullPasswordDetails = "URL: " + url + "\n" +
                    "User Name: " + userName + "\n" +
                    "Password: " + password;

            Toast.makeText(this, "Password saved!\n\n" + fullPasswordDetails, Toast.LENGTH_SHORT).show();
            clearFields();
        }
    }

    private void clearFields() {
        urlEditText.setText("");
        userNameEditText.setText("");
        passwordEditText.setText("");
    }
}
