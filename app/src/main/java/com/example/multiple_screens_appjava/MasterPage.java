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

public class MasterPage extends AppCompatActivity {

    LinearLayout masterPasswordLayout;
    EditText masterPassword;
    TextView passwordStrength;
    Button continueButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        masterPasswordLayout = findViewById(R.id.masterPasswordLayout);
        masterPassword = findViewById(R.id.masterPassword);
        passwordStrength = findViewById(R.id.passwordStrength);
        continueButton = findViewById(R.id.continueButton);
        backButton = findViewById(R.id.backButton);

        continueButton.setOnClickListener(view -> {
            String enteredPassword = masterPassword.getText().toString().trim();
            if (!TextUtils.isEmpty(enteredPassword)) {
                int passwordStrength = calculatePasswordStrength(enteredPassword);
                if (passwordStrength >= 3) {
                    // Perform necessary actions with the entered master password
                    navigateToLoginPage(); // Change to navigate to LoginPage
                } else {
                    Toast.makeText(MasterPage.this, "Password does not meet the criteria!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MasterPage.this, "Please enter a valid master password!", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(view -> navigateToMainActivity()); // Change to navigate to MainActivity

        masterPassword.addTextChangedListener(passwordWatcher);
    }

// ...

    private void navigateToLoginPage() {
        Intent intent = new Intent(MasterPage.this, LoginPage.class);
        startActivity(intent);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(MasterPage.this, MainActivity.class);
        startActivity(intent);

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
}
