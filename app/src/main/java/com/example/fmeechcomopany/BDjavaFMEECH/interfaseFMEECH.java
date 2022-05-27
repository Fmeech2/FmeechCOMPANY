package com.example.fmeechcomopany.BDjavaFMEECH;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class interfaseFMEECH {
    private Context myContext;
    private BDFmeech BDFmeech;
    private SQLiteDatabase db;

    public interfaseFMEECH(Context myContext) {
        this.myContext = myContext;
        BDFmeech = new BDFmeech(myContext);
    }
    public void openBD(){
        try {
            db=BDFmeech.getWritableDatabase();
            Log.d("ОТЛАДКА","Контроль над бд получен успешно.");
        } catch (Exception e) {
            Log.d("ОТЛАДКА",e.toString());
        }

    }
    public void insertBD(String login, String pass,String name,String about){
        try {
            ContentValues values = new ContentValues();
        values.put(constantFMEECH.KEY_NAME, login);
        values.put(constantFMEECH.KEY_LOGIN, login);//значения.помещаются(КЛЮЧ_ЛОГИН, логин);
        values.put(constantFMEECH.KEY_PASS, pass);
        values.put(constantFMEECH.KEY_ABOUT, "");

        db.insert(constantFMEECH.TABLE_NAME, null, values);//бд.вставлять(ТАБЛИЦА_ЮЗЕР,просто оставим нул,новый обьект для бд)



            Log.d("ОТЛАДКА","В БД успешно была добавленна новая запись.");
        } catch (Exception e) {
            Log.d("ОТЛАДКА",e.toString());
        }
    }
    public List<String> ListNameBD(){
      List<String> listBD = new ArrayList<>();
        Cursor cursor = db.query(
                constantFMEECH.TABLE_NAME,  // Таблица для запроса
                null,               // Массив возвращаемых столбцов (передайте null, чтобы получить все)
                null,               // Столбцы для предложения WHERE
                null,            // Значения для предложения WHERE
                null,               // не группировать строки
                null,                // не фильтровать по группам строк
                null                // Порядок сортировки
        );
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_NAME));
            listBD.add(name);
        }
        cursor.close();
       return listBD;
    }
    public void closeBD(){
        try {
            BDFmeech.close();
        } catch (Exception e) {
            Log.d("ОТЛАДКА","Не успешное закрытие БД: "+e.toString());
        }

    }
}
