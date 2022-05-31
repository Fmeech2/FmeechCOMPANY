package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.fmeechcomopany.BDjavaFMEECH.interfaseFMEECH;

import java.util.ArrayList;
import java.util.List;

public class your_profil extends AppCompatActivity {
    private interfaseFMEECH InterfaseFmeech;
    List<String> list =new ArrayList<>();
    List<String> list2 =new ArrayList<>();
    String id,login,pass,name,about;
    String id2,login2,pass2,name2,about2;

    TextView User_name,About_myself;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_your_profil);
        try
        {
        /*От сюда*/
        Bundle arguments = getIntent().getExtras();
        login = arguments.get("login").toString();    // login пациента нашей дурки
            name2 = arguments.get("name2").toString();

        InterfaseFmeech = new interfaseFMEECH(this);
        InterfaseFmeech.openBD();
        list = InterfaseFmeech.ListNameBD(login);

        id = (String) list.get(0);
        name = (String) list.get(1);
        login = (String) list.get(2);
        pass = (String) list.get(3);
        about = (String) list.get(4);
        /*До сюда*/

            InterfaseFmeech.openBD();
            list2 = InterfaseFmeech.ListNameBDLogin(name2);

            id2 = (String) list2.get(0);
            name2 = (String) list2.get(1);
            login2 = (String) list2.get(2);
            pass2 = (String) list2.get(3);
            about2 = (String) list2.get(4);

            User_name=findViewById(R.id.User_name);
            About_myself=findViewById(R.id.About_myself);
            User_name.setText(name2);
            About_myself.setText(about2);
        }
        catch (Exception e){ Log.d("ОТЛАДКА"," КРАШ при старте профиля друга." +e.toString());}
    }

    public void mes(View view) {
        //проверка по логину на совпадение в бд
        Intent abc = new Intent(this, Messege.class);
        abc.putExtra("login", login);
        abc.putExtra("name2", name2);
        Log.d("СливДанных : ","Твой логин:      "+login+", и чужой имя:       "+name2);
        startActivity(abc);

    }

    public void back5(View view) {
        finish();
    }

    public void dr(View view) {



// Удалить из др/проверит на др
//Добавить в др
        if(!InterfaseFmeech.NameFRENDbool(login,login2)){
            InterfaseFmeech.insertFREND(login,login2);
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
