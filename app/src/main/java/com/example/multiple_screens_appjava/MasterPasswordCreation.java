package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MasterPasswordCreation extends AppCompatActivity {

    LinearLayout masterPasswordLayout;
    EditText masterPassword;
    TextView passwordStrength;
    Button continueButton;
    Button backButton;

    CheckBox showPasswordCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterpassword);

        masterPasswordLayout = findViewById(R.id.masterPasswordLayout);
        masterPassword = findViewById(R.id.masterPassword);
        passwordStrength = findViewById(R.id.passwordStrength);
        continueButton = findViewById(R.id.continueButton);
        backButton = findViewById(R.id.backButton);
        showPasswordCheckbox = findViewById(R.id.showPasswordCheckbox); // Initialize CheckBox

        showPasswordCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Show password
                masterPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
            } else {
                // Hide password
                masterPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

        continueButton.setOnClickListener(view -> {
            String enteredPassword = masterPassword.getText().toString().trim();
            if (!TextUtils.isEmpty(enteredPassword)) {
                int passwordStrength = calculatePasswordStrength(enteredPassword);
                if (passwordStrength >= 3) {
                    // Perform necessary actions with the entered master password
                    navigateToLoginPage();
                } else {
                    Toast.makeText(MasterPasswordCreation.this, "Password does not meet the criteria!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MasterPasswordCreation.this, "Please enter a valid master password!",Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(view -> navigateToMainActivity());

        masterPassword.addTextChangedListener(passwordWatcher);
    }

    private void navigateToLoginPage() {
        Intent intent = new Intent(MasterPasswordCreation.this, MasterPage.class);
        startActivity(intent);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(MasterPasswordCreation.this, LoginPage.class);
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
