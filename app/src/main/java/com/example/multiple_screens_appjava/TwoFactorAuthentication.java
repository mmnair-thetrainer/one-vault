package com.example.multiple_screens_appjava;

import android.content.Intent;
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

        saveButton.setOnClickListener(view -> saveForm());
    }

    private void saveForm() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String otp = otpEditText.getText().toString().trim();

        int selectedId = twofaMethodSelectionGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String twofaMethod = selectedRadioButton.getText().toString();

        // Perform the save operation here, or any other actions based on the form data


        Intent intent = new Intent(TwoFactorAuthentication.this, FeaturesDashboard.class);
        startActivity(intent);
    }
}
