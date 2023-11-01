package com.example.multiple_screens_appjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Registration extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText dateOfBirth;
    EditText email;
    Button register;
    Button back;
    Spinner countrySpinner;
    ImageButton datePickerButton;
    private int year, month, day;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/one_vault_01";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        dateOfBirth = findViewById(R.id.dateOfBirth);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);
        back = findViewById(R.id.back);
        countrySpinner = findViewById(R.id.countrySpinner);
        datePickerButton = findViewById(R.id.datePickerButton);

        datePickerButton.setOnClickListener(view -> showDatePickerDialog());

        // Set up the date picker with the current date
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        register.setOnClickListener(view -> {
            if (checkDataEntered()) {
                // Data is valid, run the database task in a separate thread
                new Thread(new DatabaseTask()).start();
                // Handle UI updates here, if needed
            }
        });

        // Add a click listener for the "Back" button
        back.setOnClickListener(view -> {
            // Handle navigation back to the previous activity (e.g., FeaturesDashboard)
            Intent backIntent = new Intent(Registration.this, LoginPage.class);
            startActivity(backIntent);
        });

        // Add text change listeners to the EditText fields to enable/disable the "Register" button
        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        dateOfBirth.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);

        // Populate the country spinner with data
        String[] countries = {"USA", "IN", "UK", "Canada", "UAE"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Check if all EditText fields are not empty and email is valid
            boolean isAllFieldsValid = !isEmpty(username) &&
                    !isEmpty(password) &&
                    !isEmpty(dateOfBirth) &&
                    isEmail(email);

            // Enable or disable the "Register" button based on the validation result
            register.setEnabled(isAllFieldsValid);
        }
    };

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            // Handle the selected date
            this.year = year;
            this.month = month;
            this.day = dayOfMonth;
            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            dateOfBirth.setText(selectedDate);
        }, year, month, day);
        datePickerDialog.show();
    }

    boolean checkDataEntered() {
        boolean isValid = true;

        if (isEmpty(username) || !isUsernameValid(username)) {
            username.setError("Enter a valid username");
            isValid = false;
        }

        if (isEmpty(password) || !isPasswordStrong(password)) {
            password.setError("Enter a strong password (at least 8 characters)");
            isValid = false;
        }

        if (isEmpty(dateOfBirth)) {
            dateOfBirth.setError("Date of birth is required!");
            isValid = false;
        }

        if (!isEmail(email)) {
            email.setError("Enter a valid email address (e.g., example@gmail.com)");
            isValid = false;
        }

        return isValid;
    }

    boolean isUsernameValid(EditText text) {
        String username = text.getText().toString();
        // Add your validation logic for a valid username here (e.g., length constraints, character restrictions)
        // For example, check if the username contains only letters and numbers and meets a minimum length requirement.
        return username.matches("^[a-zA-Z0-9]*$") && username.length() >= 5;
    }

    boolean isPasswordStrong(EditText text) {
        CharSequence password = text.getText().toString();
        // Add your validation logic for a strong password here (e.g., length, complexity requirements)
        return password.length() >= 8; // You can add more complexity checks here.
    }

    private class DatabaseTask implements Runnable {
        @Override
        public void run() {
            Connection connection = null;

            try {
                // Register the JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection to the database
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                // Define an SQL INSERT statement (adjust it based on your database table structure)
                String sql = "users (user_name, password, date_of_birth, email) VALUES (?, ?, ?, ?)";

                // Prepare the statement
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username.getText().toString());
                preparedStatement.setString(2, password.getText().toString());
                preparedStatement.setString(3, dateOfBirth.getText().toString());
                preparedStatement.setString(4, email.getText().toString());

                // Execute the statement
                preparedStatement.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                // Handle the error as needed, e.g., show an error toast
                runOnUiThread(() -> Toast.makeText(Registration.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Handle the error as needed
                    }
                }
            }
        }
    }
}
