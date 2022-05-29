package com.example.fmeechcomopany;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fmeechcomopany.BDjavaFMEECH.interfaseFMEECH;

public class MainActivity extends AppCompatActivity {
    private interfaseFMEECH InterfaseFmeech;
    EditText login,password;
    TextView registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
        registration=findViewById(R.id.ll);
        InterfaseFmeech =new interfaseFMEECH(this);



    }

    public void da(View view) {
        InterfaseFmeech.openBD();
        try {
            if(!(!login.getText().toString().equals("")&&!login.getText().toString().equals(" "))){
                al.fmALERT("Не все данные введены","Поле: логин - пустое!",this);
            }
            else if (password.getText().toString().equals("")||password.getText().toString().equals(" ")){
                al.fmALERT("Не все данные введены","Поле: пароль - пустое!",this);
            }
            else if (InterfaseFmeech.LoginPasswordBOLL(login.getText().toString(),password.getText().toString())){
                //проверка по логину на совпадение в бд
                String loginUSER=login.getText().toString();
                Intent abc = new Intent(this, RedactionProfil.class);
                abc.putExtra("login", loginUSER);
                startActivity(abc);
            }
            else {
                al.fmALERT("Не успешный вход","Логин или пароль не совпадают",this);
            }
        }catch (Exception e){
            Log.d("ОТЛАДКА ",e.toString());
        }
    }

    public void net(View view) {
        Intent abc = new Intent(this, registration.class);
        startActivity(abc);
    }
}
