package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profil);
    }

    public void dru(View view) {
        Intent abc = new Intent(this, Friend.class);
        startActivity(abc);
    }

    public void red(View view) {
        Intent b = new Intent(this, RedactionProfil.class);
        startActivity(b);
    }

    public void sea(View view) {
        Intent c = new Intent(this, Seek.class);
        startActivity(c);
    }

    public void exit(View view) {
        Intent c = new Intent(this, MainActivity.class);
        startActivity(c);
    }
}
