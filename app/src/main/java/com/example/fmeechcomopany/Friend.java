package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Friend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_friend);
    }

    public void Perhod(View view) {
        Intent abc = new Intent(this, your_profil.class);
        startActivity(abc);
    }

    public void back(View view) {
        finish();
    }
}
