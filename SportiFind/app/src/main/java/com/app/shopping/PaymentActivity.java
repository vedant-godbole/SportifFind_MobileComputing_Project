package com.app.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private Button proceed;
    private RadioButton option1, option2, option3, option4;
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        option1 = findViewById(R.id.radio_button1);
        option2 = findViewById(R.id.radio_button2);
        option3 = findViewById(R.id.radio_button3);
        option4 = findViewById(R.id.radio_button4);
        passwordEditText = findViewById(R.id.password);


    }


    public void Proceed (View v){

        boolean isOptionSelected = option1.isChecked() || option2.isChecked() || option3.isChecked() || option4.isChecked();
        boolean isPasswordEmpty = passwordEditText.getText().toString().trim().isEmpty();

        if (!isOptionSelected) {
            // show an error message if no option is selected
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }

        if (isPasswordEmpty) {
            // show an error message if password is empty
            Toast.makeText(this, "Enter the password", Toast.LENGTH_SHORT).show();
        }

        if(isOptionSelected && !isPasswordEmpty) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Transaction In Progress..."); // Set the message to be displayed
            progressDialog.setCancelable(false); // Set whether the dialog is cancelable or not
            progressDialog.show(); // Show the dialog
            // ... Perform some time-consuming task here ...

            progressDialog.dismiss(); // Hide the dialog
            Toast.makeText(this, "Transaction Successful", Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Your final Order has been placed successfully.",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PaymentActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
}