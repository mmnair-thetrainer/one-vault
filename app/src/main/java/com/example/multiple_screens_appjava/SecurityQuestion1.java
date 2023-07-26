package com.example.multiple_screens_appjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecurityQuestion1 extends AppCompatActivity {

    LinearLayout securityQuestionLayout;
    EditText securityQuestionEditText;
    Button backButton;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security1);

        securityQuestionLayout = findViewById(R.id.securityQuestionLayout);
        securityQuestionEditText = findViewById(R.id.securityQuestionEditText);
        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String securityQuestion = securityQuestionEditText.getText().toString().trim();

                if (securityQuestion.isEmpty()) {
                    Toast.makeText(SecurityQuestion1.this, "Please enter a security question!", Toast.LENGTH_SHORT).show();
                } else {
                    // Navigate to the next screen (e.g., set up multiple questions for selected people)
                    // Here, you can pass the securityQuestion value to the next activity if needed
                    Toast.makeText(SecurityQuestion1.this, "Next button clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Go back to the previous activity (LoginPage)
            }
        });
    }
}
