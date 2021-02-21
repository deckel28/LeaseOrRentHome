package com.example.LeaseOrRentHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// page with fields to enter credit/debit card info and user's data
public class UserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        SharedPreferences myPref =
                getSharedPreferences("info", MODE_PRIVATE);
      //getting info about the chosen home
        String chosen_home = myPref.getString("chosen_home","");
        TextView chosen_home_field = findViewById(R.id.textView_chosen_home);
        chosen_home_field.setText("You chose "+chosen_home);

        //getting info about the payment type
        String chosen_payment = myPref.getString("chosen_payment","Cash");
        TextView textView_payment_type = findViewById(R.id.textView_payment_type);
        Toast.makeText(this, "You chose: "+ chosen_payment, Toast.LENGTH_SHORT).show();

      //hiding fields for credit/debit card payment info if it's cash option
        if (chosen_payment.equals("Cash")){
                textView_payment_type.setText("You paying with cash");
            EditText card_number = (EditText)findViewById(R.id.card_number);
            card_number.setVisibility(View.INVISIBLE);
            EditText exp_date_field = (EditText)findViewById(R.id.exp_date_field);
            exp_date_field.setVisibility(View.INVISIBLE);
                TextView exp_date_label = (TextView)findViewById(R.id.exp_date_label);
                exp_date_label.setVisibility(View.INVISIBLE);
            EditText cvv_field = (EditText)findViewById(R.id.cvv_field);
            cvv_field.setVisibility(View.INVISIBLE);
                TextView cvv_label = (TextView)findViewById(R.id.cvv_label);
                cvv_label.setVisibility(View.INVISIBLE);
        }
        else if (chosen_payment.equals("Credit card")){
            textView_payment_type.setText("You paying with credit card. Please, enter payment information");
        }
        else {
            textView_payment_type.setText("You paying with debit card. Please, enter payment information");
        }
    }
    //finalizing the order and validation
    public void send_order_click(View view) {
        boolean error=false; // variable to check whether there are no errors after validation

        //validating full name
        EditText full_name_Validate = (EditText)findViewById(R.id.full_name_field);
        String full_name = full_name_Validate.getText().toString().trim();
        if (full_name==""){
            Toast.makeText(this, "No entered full name", Toast.LENGTH_SHORT).show();
            error=true;
        }

        //validating invoice address
        EditText address_Validate = (EditText)findViewById(R.id.address_field);
        String address = address_Validate.getText().toString().trim();
        if (address==""){
            Toast.makeText(this, "No entered address", Toast.LENGTH_SHORT).show();
            error=true;
        }

       //validating email
        EditText emailValidate = (EditText)findViewById(R.id.email_field);
        String email = emailValidate.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (!email.matches(emailPattern))
        {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
            error=true;
        }
        //validating phone number
        EditText phone_Validate = (EditText)findViewById(R.id.phone_field);
        String phone_number = phone_Validate.getText().toString().trim();
        if (phone_number.length()!=10){
            Toast.makeText(this, "Incorrect phone number. Enter 10 digits", Toast.LENGTH_SHORT).show();
            error=true;
        }

        //accessing payment choice to see if we need to validate banking card info
        SharedPreferences myPref =
                getSharedPreferences("info", MODE_PRIVATE);
        String chosen_payment = myPref.getString("chosen_payment","Cash");
        if (!chosen_payment.equals("Cash")) {
                    //validating credit/debit card
                    EditText card_number_Validate = (EditText) findViewById(R.id.card_number);
                    String card_number = card_number_Validate.getText().toString().trim();
                    if (card_number.length() != 16) {
                        Toast.makeText(this, "Incorrect card number. Enter 16 digits", Toast.LENGTH_SHORT).show();
                        error = true;
                    }
                    //validating expiry date
                    EditText exp_date_Validate = (EditText) findViewById(R.id.exp_date_field);
                    String exp_date_st = exp_date_Validate.getText().toString().trim();

                    if (exp_date_st.length() != 4) {
                        Toast.makeText(this, "Incorrect expiry date", Toast.LENGTH_SHORT).show();
                        error = true;
                    }

                    //validating cvv code
                    EditText cvv_Validate = (EditText) findViewById(R.id.cvv_field);
                    String cvv = cvv_Validate.getText().toString().trim();
                    if (cvv.length() != 3) {
                        Toast.makeText(this, "Incorrect CVV", Toast.LENGTH_SHORT).show();
                        error = true;
                    }
        }
        if (!error) { Toast.makeText(this, "Order successfully sent!", Toast.LENGTH_SHORT).show();}
    }
}