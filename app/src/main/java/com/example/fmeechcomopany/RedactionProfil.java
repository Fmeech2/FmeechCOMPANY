package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.fmeechcomopany.BDjavaFMEECH.interfaseFMEECH;

import java.util.ArrayList;
import java.util.List;

public class RedactionProfil extends AppCompatActivity {
    private interfaseFMEECH InterfaseFmeech;
    List<String> list =new ArrayList<>();
    String id,login,pass,name,about;
    String id2,login2,name2,about2;


    EditText User_name,password,About;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_redaction_profil);

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


        User_name = findViewById(R.id.User_name);
        password = findViewById(R.id.password);
        About = findViewById(R.id.About_myself);

        User_name.setText(name);
        About.setText(about);

    }

    public void back2(View view) {
        finish();
    }

    public void save(View view) {
        //Как редактировать строки в Базах Данных
        if(password.getText().toString().equals("")||password.getText().toString().equals(" ")){
            InterfaseFmeech.UpdateBD(login,pass,User_name.getText().toString(),About.getText().toString());
        }
        else {
            InterfaseFmeech.UpdateBD(login,password.getText().toString(),User_name.getText().toString(),About.getText().toString());
        }

        //проверка по логину на совпадение в бд
        Intent abc = new Intent(this, MyProfil.class);
        abc.putExtra("login", login);
        startActivity(abc);
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
