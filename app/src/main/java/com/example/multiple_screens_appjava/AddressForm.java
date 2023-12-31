package com.example.multiple_screens_appjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddressForm extends AppCompatActivity {

    EditText titleEditText;
    EditText streetEditText;
    EditText apartmentEditText;
    EditText cityEditText;
    EditText zipCodeEditText;
    EditText countryEditText;
    Button saveButton;
    Button clearButton;
    Button backButton; // Define the backButton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        titleEditText = findViewById(R.id.titleEditText);
        streetEditText = findViewById(R.id.streetEditText);
        apartmentEditText = findViewById(R.id.apartmentEditText);
        cityEditText = findViewById(R.id.cityEditText);
        zipCodeEditText = findViewById(R.id.zipCodeEditText);
        countryEditText = findViewById(R.id.countryEditText);
        saveButton = findViewById(R.id.saveButton);
        clearButton = findViewById(R.id.clearButton);
        backButton = findViewById(R.id.backButton); // Initialize the backButton

        saveButton.setOnClickListener(view -> saveAddress());
        clearButton.setOnClickListener(view -> clearFields());

        // Set a click listener for the backButton
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(AddressForm.this, FeaturesDashboard.class);
            startActivity(intent);
        });
    }

    private void saveAddress() {
        String title = titleEditText.getText().toString().trim();
        String street = streetEditText.getText().toString().trim();
        String apartment = apartmentEditText.getText().toString().trim();
        String city = cityEditText.getText().toString().trim();
        String zipCode = zipCodeEditText.getText().toString().trim();
        String country = countryEditText.getText().toString().trim();

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(street) || TextUtils.isEmpty(city)
                || TextUtils.isEmpty(zipCode) || TextUtils.isEmpty(country)) {
            Toast.makeText(this, "Please fill in all address details!", Toast.LENGTH_SHORT).show();
        } else {
            // Save the address to your desired storage or perform any other actions
            String fullAddress = title + "\n" +
                    "Street: " + street + "\n" +
                    "Apartment/Unit: " + apartment + "\n" +
                    "City: " + city + "\n" +
                    "Zip Code: " + zipCode + "\n" +
                    "Country: " + country;

            Toast.makeText(this, "Address saved!\n\n" + fullAddress, Toast.LENGTH_SHORT).show();
            clearFields();

            // Navigate to the DashboardActivity
            Intent intent = new Intent(AddressForm.this, FeaturesDashboard.class);
            startActivity(intent);
        }
    }

    private void clearFields() {
        titleEditText.setText("");
        streetEditText.setText("");
        apartmentEditText.setText("");
        cityEditText.setText("");
        zipCodeEditText.setText("");
        countryEditText.setText("");
    }
}
