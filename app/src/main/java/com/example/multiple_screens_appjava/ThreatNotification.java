package com.example.multiple_screens_appjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThreatNotification extends AppCompatActivity {

    // You need to implement Google Maps Android SDK or any other MapView as appropriate.
    // For demonstration purposes, let's assume you are using Google Maps Android SDK.
    // Make sure to set the correct import and usage of the Google Map View.

    // MapView googleMapView;

    RadioGroup priorityLevelSelectionGroup;
    RadioButton lowPriorityRadioButton;
    RadioButton mediumPriorityRadioButton;
    RadioButton highPriorityRadioButton;
    Button attachmentUploadButton;
    EditText contactInfoEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threatnotification);

        // Initialize the Google Map View
        // googleMapView = findViewById(R.id.googleMapView);

        priorityLevelSelectionGroup = findViewById(R.id.priorityLevelSelectionGroup);
        lowPriorityRadioButton = findViewById(R.id.lowPriorityRadioButton);
        mediumPriorityRadioButton = findViewById(R.id.mediumPriorityRadioButton);
        highPriorityRadioButton = findViewById(R.id.highPriorityRadioButton);
        attachmentUploadButton = findViewById(R.id.attachmentUploadButton);
        contactInfoEditText = findViewById(R.id.contactInfoEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(view -> saveForm());
    }

    private void saveForm() {
        int selectedPriorityId = priorityLevelSelectionGroup.getCheckedRadioButtonId();
        String priorityLevel = "Low"; // Default value

        if (selectedPriorityId == R.id.lowPriorityRadioButton) {
            priorityLevel = "Low";
        } else if (selectedPriorityId == R.id.mediumPriorityRadioButton) {
            priorityLevel = "Medium";
        } else if (selectedPriorityId == R.id.highPriorityRadioButton) {
            priorityLevel = "High";
        }

        String additionalContactInfo = contactInfoEditText.getText().toString().trim();

        // Perform the save operation here
        // For demonstration purposes, we'll just display a toast message indicating the form is saved.
        String formData = "Priority Level: " + priorityLevel + "\n" +
                "Additional Contact Information: " + additionalContactInfo;

        Toast.makeText(this, "Form Data Saved:\n\n" + formData, Toast.LENGTH_LONG).show();
    }
}