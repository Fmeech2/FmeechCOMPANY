package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fmeechcomopany.BDjavaFMEECH.interfaseFMEECH;

import java.util.ArrayList;
import java.util.List;

public class MyProfil extends AppCompatActivity {
    private interfaseFMEECH InterfaseFmeech;
    List<String> list =new ArrayList<>();
    String id,login,pass,name,about;

    TextView User_name,About;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_my_profil);
        try {



            /*От сюда*/
            Bundle arguments = getIntent().getExtras();
            login = arguments.get("login").toString();    // login пациента нашей дурки

            InterfaseFmeech = new interfaseFMEECH(this);
            InterfaseFmeech.openBD();
            list = InterfaseFmeech.ListNameBD(login);

            id = (String) list.get(0);
            name = (String) list.get(1);
            login = (String) list.get(2);
            pass = (String) list.get(3);
            about = (String) list.get(4);
            /*До сюда*/


            About=findViewById(R.id.About_myself);
            User_name=findViewById(R.id.User_name);

            About.setText(about);
            User_name.setText(name);}
        catch (Exception e){
            Log.d("ОТЛАДКА ",e.toString());
        }
    }

    public void dru(View view) {
        //проверка по логину на совпадение в бд
        Intent abc = new Intent(this, Friend.class);
        abc.putExtra("login", login);
        startActivity(abc);
    }

    public void red(View view) {
        //проверка по логину на совпадение в бд
        Intent abc = new Intent(this, RedactionProfil.class);
        abc.putExtra("login", login);
        startActivity(abc);
    }

    public void sea(View view) {
        //проверка по логину на совпадение в бд
        Intent abc = new Intent(this, Seek.class);
        abc.putExtra("login", login);
        startActivity(abc);
    }

    public void exit(View view) {
        Intent c = new Intent(this, MainActivity.class);
        startActivity(c);
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
