package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Seek extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
    }

    public void back4(View view) {
        finish();
    }

    public void profol(View view) {
        Intent abc = new Intent(this, your_profil.class);
        startActivity(abc);
    }
}
