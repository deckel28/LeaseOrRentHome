package com.example.LeaseOrRentHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

// payment options with radio buttons
public class PaymentOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
    }

    public void onClickPaymentChoice(View view) {
        RadioGroup radioGroup = findViewById(R.id.payment_options);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        //making sure that user picked an option - validation
        if (selectedId == -1) {
            Toast.makeText(this, "You didn't choose an option", Toast.LENGTH_SHORT).show();
        } else {
            // find the radiobutton by returned id
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            String chosen_payment = (String) radioButton.getText();

            SharedPreferences myPreference =
                    getSharedPreferences("info", 0);
            SharedPreferences.Editor prefEditor = myPreference.edit();
            //store address and phone number in memory
            prefEditor.putString("chosen_payment", chosen_payment);
            //commit the transaction
            prefEditor.commit();

            Intent intent = new Intent(this, UserInfo.class);
            startActivity(intent);
        }
    }
}