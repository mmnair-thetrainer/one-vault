package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button passwordFormButton = findViewById(R.id.passwordFormButton);
        Button addressFormButton = findViewById(R.id.addressFormButton);
        Button notesFormButton = findViewById(R.id.notesFormButton);
        Button nextButton = findViewById(R.id.nextButton);

        passwordFormButton.setOnClickListener(view -> openPasswordForm());

        addressFormButton.setOnClickListener(view -> openAddressForm());

        notesFormButton.setOnClickListener(view -> openNotesForm());

        nextButton.setOnClickListener(view -> openFeaturesDashboard());
    }

    public void openPasswordForm() {
        Intent intent = new Intent(DashboardActivity.this, PasswordForm.class);
        startActivity(intent);
    }

    public void openAddressForm() {
        Intent intent = new Intent(DashboardActivity.this, AddressForm.class);
        startActivity(intent);
    }

    public void openNotesForm() {
        Intent intent = new Intent(DashboardActivity.this, NotesForm.class);
        startActivity(intent);
    }
    public void openFeaturesDashboard() {
        Intent intent = new Intent(DashboardActivity.this, FeaturesDashboard.class);
        startActivity(intent);
    }
}
