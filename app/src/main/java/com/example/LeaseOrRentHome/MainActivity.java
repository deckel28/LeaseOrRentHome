package com.example.LeaseOrRentHome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
  public void onClickEnter(View view) {
        Intent intent = new Intent(this, HomeTypes.class);
        startActivity(intent);
    }
}