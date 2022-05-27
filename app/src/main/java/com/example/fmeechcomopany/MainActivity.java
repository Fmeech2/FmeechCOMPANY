package com.example.fmeechcomopany;

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

    public void da(View view) {
        Intent abc = new Intent(this, RedactionProfil.class);
        startActivity(abc);
    }

    public void net(View view) {
        Intent abc = new Intent(this, registration.class);
        startActivity(abc);
    }
}
