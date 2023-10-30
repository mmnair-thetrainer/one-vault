package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsPage extends AppCompatActivity {

    EditText accountInfoEditText;
    EditText currentPasswordEditText;
    EditText newPasswordEditText;
    EditText confirmPasswordEditText;
    CheckBox enable2FAcheckbox;
    EditText secretKeyEditText;
    EditText backupCodesEditText;
    CheckBox emailNotificationCheckBox;
    CheckBox pushNotificationCheckBox;
    Button saveButton;

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingspage);

        accountInfoEditText = findViewById(R.id.accountInfoEditText);
        currentPasswordEditText = findViewById(R.id.currentPasswordEditText);
        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        enable2FAcheckbox = findViewById(R.id.enable2FAcheckbox);
        secretKeyEditText = findViewById(R.id.secretKeyEditText);
        backupCodesEditText = findViewById(R.id.backupCodesEditText);
        emailNotificationCheckBox = findViewById(R.id.emailNotificationCheckBox);
        pushNotificationCheckBox = findViewById(R.id.pushNotificationCheckBox);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);

        saveButton.setOnClickListener(view -> saveForm());
        backButton.setOnClickListener(view -> navigateToFeaturesDashboard());
    }

    private void saveForm() {
        String accountInfo = accountInfoEditText.getText().toString().trim();
        String currentPassword = currentPasswordEditText.getText().toString().trim();
        String newPassword = newPasswordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();
        boolean enable2FA = enable2FAcheckbox.isChecked();
        String secretKey = secretKeyEditText.getText().toString().trim();
        String backupCodes = backupCodesEditText.getText().toString().trim();
        boolean emailNotification = emailNotificationCheckBox.isChecked();
        boolean pushNotification = pushNotificationCheckBox.isChecked();

        Intent intent = new Intent(SettingsPage.this, FeaturesDashboard.class);
        startActivity(intent);

        // Perform the save operation here, or any other actions based on the form data
        // For demonstration purposes, we'll just display a toast message with the form data.
        String formData = "Account Information: " + accountInfo + "\n" +
                "Current Password: " + currentPassword + "\n" +
                "New Password: " + newPassword + "\n" +
                "Confirm Password: " + confirmPassword + "\n" +
                "Enable 2FA: " + enable2FA + "\n" +
                "Secret Key: " + secretKey + "\n" +
                "Backup Codes: " + backupCodes + "\n" +
                "E-mail Notification: " + emailNotification + "\n" +
                "Push Notifications: " + pushNotification;

        Toast.makeText(this, "Form Data Saved:\n\n" + formData, Toast.LENGTH_LONG).show();
    }
    private void navigateToFeaturesDashboard() {
        Intent intent = new Intent(SettingsPage.this, FeaturesDashboard.class);
        startActivity(intent);
    }
}
