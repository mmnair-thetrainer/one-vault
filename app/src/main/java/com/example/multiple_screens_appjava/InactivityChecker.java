package com.example.multiple_screens_appjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InactivityChecker extends AppCompatActivity {

    TextView lastLoginTimeTextView;
    TableLayout tableLayout;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inactivitychecker);

        lastLoginTimeTextView = findViewById(R.id.lastLoginTimeTextView);
        tableLayout = findViewById(R.id.tableLayout);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveForm();
            }
        });
    }

    private void saveForm() {
        // Perform the save operation here
        // For demonstration purposes, we'll just display a toast message indicating the form is saved.
        Toast.makeText(this, "Form Data Saved", Toast.LENGTH_SHORT).show();
    }
}
