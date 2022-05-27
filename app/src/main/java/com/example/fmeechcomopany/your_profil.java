package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class your_profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_profil);
    }

    public void mes(View view) {
        Intent abc = new Intent(this, Messege.class);
        startActivity(abc);
    }

    public void back5(View view) {
        finish();
    }

    public void dr(View view) {
        Intent abc = new Intent(this, Friend.class);
        startActivity(abc);
    }
}
