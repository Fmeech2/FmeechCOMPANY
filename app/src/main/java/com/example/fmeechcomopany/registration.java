package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fmeechcomopany.BDjavaFMEECH.interfaseFMEECH;

public class registration extends AppCompatActivity {
    private interfaseFMEECH InterfaseFmeech;
    EditText login,password,password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        login=findViewById(R.id.login);
        password=findViewById(R.id.true_password);
        password2=findViewById(R.id.password);
        InterfaseFmeech =new interfaseFMEECH(this);
    }

    public void back3(View view) {
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        InterfaseFmeech.openBD();
    }

    public void RegУdachno() {
        InterfaseFmeech.insertBD(login.getText().toString(),password.getText().toString(),null,null);
    }
    public void zar(View view) {
        Intent abc = new Intent(this, RedactionProfil.class);
        startActivity(abc);
        RegУdachno();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        InterfaseFmeech.closeBD();
    }
}








