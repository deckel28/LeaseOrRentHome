package com.example.LeaseOrRentHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

// second screen with options menu control to choose type of the home
public class HomeTypes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_types);

    }

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