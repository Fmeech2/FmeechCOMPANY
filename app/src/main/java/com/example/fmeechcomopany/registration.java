package com.example.fmeechcomopany;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_registration);
        login=findViewById(R.id.login);
        password=findViewById(R.id.true_password);
        password2=findViewById(R.id.password);
        InterfaseFmeech =new interfaseFMEECH(this);
    }

    public void back3(View view) {
        finish();
    }

    //Метод: Зарегестрироваться
    public void zar(View view) {
        try {
            if(!(!login.getText().toString().equals("")&&!login.getText().toString().equals(" "))){
                al.fmALERT("Не все данные введены","Поле: логин - пустое!",this);
            }
            else if (password.getText().toString().equals("")||password.getText().toString().equals(" ")){
                al.fmALERT("Не все данные введены","Поле: пароль - пустое!",this);
            }
            else if (password2.getText().toString().equals("")||password2.getText().toString().equals(" ")){
                al.fmALERT("Не все данные введены","Поле: пароль - пустое!",this);
            }
            else if (!password.getText().toString().equals(password2.getText().toString())){
                al.fmALERT("Не верный пароль!","Пароли не совпадают.",this);
            }
            //проверка по логину на совпадение в бд
            else if (InterfaseFmeech.LoginPasswordBOLL(login.getText().toString(),null)){
                al.fmALERT("ОШИБКА РЕГИСТРАЦИИ","Такой логин уже сеществует.",this);
            }
            else
            {
                InterfaseFmeech.insertBD(login.getText().toString(),password.getText().toString(),null,null);
                String LoginUSER = login.getText().toString();
                Intent abc = new Intent(this, RedactionProfil.class);
                abc.putExtra("login", LoginUSER);
                startActivity(abc);
            }
        }
        catch (Exception e){
            al.fmALERT("КРАШ",e.toString(),this);
        }
    }



    //Открыть бд
    @Override
    protected void onResume() {
        super.onResume();
        InterfaseFmeech.openBD();
    }
    //Закрыть бд
    @Override
    protected void onDestroy() {
        super.onDestroy();
        InterfaseFmeech.closeBD();
    }
}




