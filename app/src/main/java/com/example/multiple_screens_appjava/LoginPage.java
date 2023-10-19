package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage extends AppCompatActivity {

    LinearLayout loginLayout;
    EditText usernameEditText;
    EditText passwordEditText;
    TextView passwordStrength;
    Button createAccountButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLayout = findViewById(R.id.loginLayout);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordStrength = findViewById(R.id.passwordStrength);
        createAccountButton = findViewById(R.id.createAccountButton);
        loginButton = findViewById(R.id.loginButton);

        // Disable the login button initially
        loginButton.setEnabled(false);

        createAccountButton.setOnClickListener(view -> {
            // Navigate to the Registration page
            Intent Intent = new Intent(LoginPage.this, Registration.class);
            startActivity(Intent);
        });

        loginButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                // Perform login authentication here
                // If authentication is successful, navigate to the DashboardActivity
                navigateToDashboardActivity();
            } else {
                Toast.makeText(LoginPage.this, "Please enter username and password!", Toast.LENGTH_SHORT).show();
            }
        });

        passwordEditText.addTextChangedListener(passwordWatcher);
    }

    private TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String password = editable.toString();
            int passwordStrength = calculatePasswordStrength(password);
            updatePasswordStrengthText(passwordStrength);

            // Enable the login button if the password is not empty and meets the criteria
            loginButton.setEnabled(!TextUtils.isEmpty(password) && passwordStrength >= 3);
        }
    };

    private int calculatePasswordStrength(String password) {
        // Criteria: More than 8 characters, a special character, at least one capital letter, a number
        int strength = 0;

        if (password.length() > 8) {
            strength++;
        }
        if (containsSpecialCharacter(password)) {
            strength++;
        }
        if (containsCapitalLetter(password)) {
            strength++;
        }
        if (containsNumber(password)) {
            strength++;
        }

        return strength;
    }

    private boolean containsSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean containsCapitalLetter(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean containsNumber(String password) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private void updatePasswordStrengthText(int passwordStrength) {
        // Update the password strength TextView with the appropriate text based on the password strength value
        String strengthText;
        switch (passwordStrength) {
            case 0:
                strengthText = "Weak";
                break;
            case 1:
                strengthText = "Medium";
                break;
            case 2:
                strengthText = "Strong";
                break;
            case 3:
                strengthText = "Very Strong";
                break;
            default:
                strengthText = "";
                break;
        }
        this.passwordStrength.setText(strengthText);
    }

    private void navigateToDashboardActivity() {
        Intent intent = new Intent(LoginPage.this, DashboardActivity.class);
        startActivity(intent);
    }
}
