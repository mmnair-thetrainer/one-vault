package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FeaturesDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featuresdashboard);

        Button twoFactorAuthButton = findViewById(R.id.twoFactorAuthButton);
        Button threatNotificationButton = findViewById(R.id.threatNotificationButton);
        Button passwordInheritanceButton = findViewById(R.id.passwordInheritanceButton);
        Button inactivityCheckerButton = findViewById(R.id.inactivityCheckerButton);
        Button passwordEnhancementButton = findViewById(R.id.passwordEnhancementButton);
        Button settingsButton = findViewById(R.id.settingsButton);

        twoFactorAuthButton.setOnClickListener(view -> openTwoFactorAuthPage());
        threatNotificationButton.setOnClickListener(view -> openThreatNotificationPage());
        passwordInheritanceButton.setOnClickListener(view -> openPasswordInheritancePage());
        inactivityCheckerButton.setOnClickListener(view -> openInactivityCheckerPage());
        passwordEnhancementButton.setOnClickListener(view -> openPasswordEnhancementPage());
        settingsButton.setOnClickListener(view -> openSettingsPage());
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
