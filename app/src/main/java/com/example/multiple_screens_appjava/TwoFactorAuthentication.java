package com.example.multiple_screens_appjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TwoFactorAuthentication extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    EditText otpEditText;
    RadioGroup twofaMethodSelectionGroup;
    Button resendOTPButton;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twofactorauthentication);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        otpEditText = findViewById(R.id.otpEditText);
        twofaMethodSelectionGroup = findViewById(R.id.twofaMethodSelectionGroup);
        resendOTPButton = findViewById(R.id.resendOTPButton);
        saveButton = findViewById(R.id.submitButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveForm();
            }
        });
    }

    private void saveForm() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String otp = otpEditText.getText().toString().trim();

        int selectedId = twofaMethodSelectionGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String twofaMethod = selectedRadioButton.getText().toString();

        // Perform the save operation here, or any other actions based on the form data
        // For demonstration purposes, we'll just display a toast message with the form data.
        String formData = "Username: " + username + "\n" +
                "Password: " + password + "\n" +
                "OTP: " + otp + "\n" +
                "2FA Method: " + twofaMethod;

        Toast.makeText(this, "Form Data Saved:\n\n" + formData, Toast.LENGTH_LONG).show();
    }
}
