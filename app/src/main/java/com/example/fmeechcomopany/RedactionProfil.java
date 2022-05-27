package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RedactionProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redaction_profil);
    }

    public void save(View view) {
        Intent abc = new Intent(this, MyProfil.class);
        startActivity(abc);
    }

    public void back2(View view) {
        finish();
    }
}
