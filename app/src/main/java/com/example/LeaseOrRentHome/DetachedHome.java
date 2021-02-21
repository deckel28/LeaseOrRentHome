package com.example.LeaseOrRentHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class DetachedHome extends AppCompatActivity {
    private CheckBox det1checkbox,det2checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detached_home);
        det1checkbox=findViewById(R.id.checkBox3);
        det2checkbox=findViewById(R.id.checkBox4);
    }
    public void save_checked(View view){//saving information from checkboxes to further process on checkout page
        SharedPreferences myPreference =
                getSharedPreferences("info", 0);
        //prepare it for edit by creating an Edit object
        SharedPreferences.Editor prefEditor = myPreference.edit();
        boolean det1state = det1checkbox.isChecked();
        boolean det2state = det2checkbox.isChecked();
        prefEditor.putBoolean("det1state",det1state);
        prefEditor.putBoolean("det2state",det2state);
        prefEditor.commit();
        Toast.makeText(this, "Added to checkout",Toast.LENGTH_SHORT).show();

    }
    public void checkout_page_open(View view) {
        save_checked(view); // in case user wants to proceed right away without clicking on "Add to checkout" button
        Intent intent = new Intent(this, Checkout.class);
        startActivity(intent);
    }

    ///////////////////
    // OPTIONS MENU
    ///////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.apartment:
                Toast.makeText(this, "You selected apartment!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Apartment.class);
                startActivity(intent1);
                break;

            case R.id.detachedhome:
                Toast.makeText(this, "You selected Detached Home!", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, DetachedHome.class);
                startActivity(intent2);
                break;

            case R.id.semidet:
                Toast.makeText(this, "You selected Semi-detached Home", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, SemiDetached.class);
                startActivity(intent3);
                break;

            case R.id.condo:
                Toast.makeText(this, "You selected Condominium apartment!", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Condo.class);
                startActivity(intent4);
                break;
            case R.id.townhouse:
                Toast.makeText(this, "You selected Town house!", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, Townhouse.class);
                startActivity(intent5);
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;

    }
}