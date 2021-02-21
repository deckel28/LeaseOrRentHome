package com.example.LeaseOrRentHome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//a list of selected homes with radio buttons
// NOTE to professor: I know that my solution is lame, but at least it works now
public class Checkout extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        TextView noOptionsMessage = (TextView)findViewById(R.id.noOptionsMessage);
        noOptionsMessage.setVisibility(View.INVISIBLE);

        //getting previously saved info about chosen homes
        SharedPreferences myPref =
                getSharedPreferences("info", MODE_PRIVATE);
        boolean apt1state = myPref.getBoolean("apt1state", false);
        boolean apt2state = myPref.getBoolean("apt2state", false);

        boolean condo1state = myPref.getBoolean("condo1state", false);
        boolean condo2state = myPref.getBoolean("condo2state", false);

        boolean det1state = myPref.getBoolean("det1state", false);
        boolean det2state = myPref.getBoolean("det2state", false);

        boolean semidet1state = myPref.getBoolean("semidet1state", false);
        boolean semidet2state = myPref.getBoolean("semidet2state", false);

        boolean townhouse1state = myPref.getBoolean("townhouse1state", false);
        boolean townhouse2state = myPref.getBoolean("townhouse2state", false);
        //
        //Below is temporary code for debugging
        //
//        TextView textViewResults = findViewById(R.id.textViewResults);
//        textViewResults.setText("apt1state: " + apt1state + "\n" +
//                "apt2state: " + apt2state + "\n" +
//                "condo1state: " + condo1state + "\n" +
//                "condo2state: " + condo2state + "\n" +
//                "det1state: " + det1state + "\n" +
//                "det2state: " + det2state + "\n" +
//                "semidet1state: " + semidet1state + "\n" +
//                "semidet2state: " + semidet2state + "\n" +
//                "townhouse1state: " + townhouse1state + "\n" +
//                "townhouse2state: " + townhouse2state + "\n");

        boolean options_exist=false; // to check whether there are selected options at all
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg_homes);

      //checking every checkbox and adding radio button if it's checked
        if (apt1state){
            RadioButton rb1 = new RadioButton(this);
            rb1.setText(R.string.apt1);
            rb1.setId(1);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb1, params);
            options_exist=true;
        }
        if (apt2state){
            RadioButton rb2 = new RadioButton(this);
            rb2.setText(R.string.apt2);
            rb2.setId(2);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb2, params);
            options_exist=true;

        }
        if (condo1state){
            RadioButton rb3 = new RadioButton(this);
            rb3.setText(R.string.condo1);
            rb3.setId(3);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb3, params);
            options_exist=true;
        }
        if (condo2state){
            RadioButton rb4 = new RadioButton(this);
            rb4.setText(R.string.condo2);
            rb4.setId(4);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb4, params);
            options_exist=true;
        }
        if (det1state){
            RadioButton rb5 = new RadioButton(this);
            rb5.setText(R.string.det1);
            rb5.setId(5);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb5, params);
            options_exist=true;
        }

        if (det2state){
            RadioButton rb6 = new RadioButton(this);
            rb6.setText(R.string.det2);
            rb6.setId(6);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb6, params);
            options_exist=true;
        }
        if (semidet1state){
            RadioButton rb7 = new RadioButton(this);
            rb7.setText(R.string.semidet1);
            rb7.setId(7);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb7, params);
            options_exist=true;
        }

        if (semidet2state){
            RadioButton rb8 = new RadioButton(this);
            rb8.setText(R.string.semidet2);
            rb8.setId(8);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb8, params);
            options_exist=true;
        }
        if (townhouse1state){
            RadioButton rb9 = new RadioButton(this);
            rb9.setText(R.string.townhouse1);
            rb9.setId(9);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb9, params);
            options_exist=true;
        }

        if (townhouse2state){
            RadioButton rb10 = new RadioButton(this);
            rb10.setText(R.string.townhouse2);
            rb10.setId(10);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb10, params);
            options_exist=true;
        }
         ////
        // in case user didn't select any homes - hiding the button and showing the message
        /////
        if (!options_exist){
            Button PayOpt_button = (Button)findViewById(R.id.PayOpt_button);
            PayOpt_button.setVisibility(View.INVISIBLE);
            noOptionsMessage.setVisibility(View.VISIBLE);

        }
    }

    public void PayOpt_click(View view) {
        RadioGroup radioGroup = findViewById(R.id.rg_homes);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        //making sure that user picked an option - validation
        if (selectedId==-1){
            Toast.makeText(this, "You didn't choose an option", Toast.LENGTH_SHORT).show();
        }
        else {
        // find the radiobutton by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        String chosen_home = (String)radioButton.getText();
        SharedPreferences myPreference =
                    getSharedPreferences("info", 0);
            SharedPreferences.Editor prefEditor = myPreference.edit();
            //store address and phone number in memory
            prefEditor.putString("chosen_home", chosen_home);
            //commit the transaction
            prefEditor.commit();

            Intent intent = new Intent(this, PaymentOptions.class);
            startActivity(intent);
        }
    }
}