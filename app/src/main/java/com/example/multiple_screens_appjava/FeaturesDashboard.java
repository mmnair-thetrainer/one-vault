package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FeaturesDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featuresdashboard);

        Button passwordFormButton = findViewById(R.id.passwordFormButton);
        Button notesFormButton = findViewById(R.id.notesFormButton);
        Button addressFormButton = findViewById(R.id.addressFormButton);
        Button twoFactorAuthButton = findViewById(R.id.twoFactorAuthButton);
        Button threatNotificationButton = findViewById(R.id.threatNotificationButton);
        Button passwordInheritanceButton = findViewById(R.id.passwordInheritanceButton);
        Button inactivityCheckerButton = findViewById(R.id.inactivityCheckerButton);
        Button passwordEnhancementButton = findViewById(R.id.passwordEnhancementButton);
        Button settingsButton = findViewById(R.id.settingsButton);
        Button backButton = findViewById(R.id.backButton);

        passwordFormButton.setOnClickListener(view -> openPasswordFormPage());
        notesFormButton.setOnClickListener(view -> openNotesFormPage());
        addressFormButton.setOnClickListener(view -> openAddressFormPage());
        twoFactorAuthButton.setOnClickListener(view -> openTwoFactorAuthPage());
        threatNotificationButton.setOnClickListener(view -> openThreatNotificationPage());
        passwordInheritanceButton.setOnClickListener(view -> openPasswordInheritancePage());
        inactivityCheckerButton.setOnClickListener(view -> openInactivityCheckerPage());
        passwordEnhancementButton.setOnClickListener(view -> openPasswordEnhancementPage());
        settingsButton.setOnClickListener(view -> openSettingsPage());
        backButton.setOnClickListener(view -> openLoginPage());
    }
    public void openPasswordFormPage() {
        Intent intent = new Intent(FeaturesDashboard.this, PasswordForm.class);
        startActivity(intent);
    }

    public void openNotesFormPage() {
        Intent intent = new Intent(FeaturesDashboard.this, NotesForm.class);
        startActivity(intent);
    }

    public void openAddressFormPage() {
        Intent intent = new Intent(FeaturesDashboard.this, AddressForm.class);
        startActivity(intent);
    }

    public void openLoginPage() {
        Intent intent = new Intent(FeaturesDashboard.this, LoginPage.class);
        startActivity(intent);
    }
    public void openTwoFactorAuthPage() {
        Intent intent = new Intent(FeaturesDashboard.this, TwoFactorAuthentication.class);
        startActivity(intent);
    }

    public void openThreatNotificationPage() {
        Intent intent = new Intent(FeaturesDashboard.this, ThreatNotification.class);
        startActivity(intent);
    }

    public void openPasswordInheritancePage() {
        Intent intent = new Intent(FeaturesDashboard.this, PasswordInheritance.class);
        startActivity(intent);
    }

    public void openInactivityCheckerPage() {
        Intent intent = new Intent(FeaturesDashboard.this, InactivityChecker.class);
        startActivity(intent);
    }

    public void openPasswordEnhancementPage() {
        Intent intent = new Intent(FeaturesDashboard.this, PasswordEnhancement.class);
        startActivity(intent);
    }

    public void openSettingsPage() {
        Intent intent = new Intent(FeaturesDashboard.this, SettingsPage.class);
        startActivity(intent);
    }

}
