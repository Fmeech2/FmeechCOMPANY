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

    //Конструктор экземпляра класса
    public interfaseFMEECH(Context myContext) {
        this.myContext = myContext;
        BDFmeech = new BDFmeech(myContext);
    }



    //Добавить в БД в таблицу ЮЗЕР новую запись
    public void insertBD(String login, String pass,String name,String about){
        try {
            ContentValues values = new ContentValues();
            values.put(constantFMEECH.KEY_NAME, login);
            values.put(constantFMEECH.KEY_LOGIN, login);//значения.помещаются(КЛЮЧ_ЛОГИН, логин);
            values.put(constantFMEECH.KEY_PASS, pass);
            values.put(constantFMEECH.KEY_ABOUT, "");

            db.insert(constantFMEECH.TABLE_NAME1, null, values);//бд.вставлять(ТАБЛИЦА_ЮЗЕР,просто оставим нул,новый обьект для бд)



            Log.d("ОТЛАДКА","В БД успешно была добавленна новая запись.");
        } catch (Exception e) {
            Log.d("ОТЛАДКА",e.toString());
        }
    }

    //Вход под своей учёт записью (проверка на совпадение логин/пароль в таблице юзер)
    public boolean LoginPasswordBOLL(String login,String password){
        try {
            Cursor cursor = db.query(
                    constantFMEECH.TABLE_NAME1,  // Таблица для запроса
                    null,               // Массив возвращаемых столбцов (передайте null, чтобы получить все)
                    null,               // Столбцы для предложения WHERE
                    null,            // Значения для предложения WHERE
                    null,               // не группировать строки
                    null,                // не фильтровать по группам строк
                    null                // Порядок сортировки
            );

            //Если нужно проверить лишь на наличие логина
            if (password == null){
                while (cursor.moveToNext()){
                    if(login.equals(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN)))){
                        cursor.close();
                        return true;
                    }
                }
            }
            //Если нужно проверить совпадение логина и пароля
            else {
                while (cursor.moveToNext()){
                    if(login.equals(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN)))){
                        if(password.equals(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_PASS)))){
                            cursor.close();
                            return true;
                        }
                    }
                }
            }
            cursor.close();
            return false;
        }
        catch (Exception e){
            Log.d("ОТЛАДКА",e.toString());
            return false;
        }
    }

    //бесполезный лист
    public List<String> ListNameBD(String login){
        try{
            List<String> listBD = new ArrayList<>();
            Cursor cursor = db.query(
                    constantFMEECH.TABLE_NAME1,  // Таблица для запроса
                    null,               // Массив возвращаемых столбцов (передайте null, чтобы получить все)
                    null,               // Столбцы для предложения WHERE
                    null,            // Значения для предложения WHERE
                    null,               // не группировать строки
                    null,                // не фильтровать по группам строк
                    null                // Порядок сортировки
            );
       while (cursor.moveToNext()){
           Log.d("ОТЛАДКА (БД): ",(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ID)))+     " " +     (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_NAME)))+         " " +     (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN)))+           " " +   (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_PASS)))+         " " +     (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ABOUT))));

            if(login.equals(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN)))){
                listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ID)));   //0
                listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_NAME))); //1
                listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN)));//2
                listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_PASS))); //3
                listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ABOUT)));//4
            }
            /*
            Шаблон вытаскивания данных из листа
            String id =(String) listBD.get(0);
            String name =(String) listBD.get(1);
            String login =(String) listBD.get(2);
            String pass =(String) listBD.get(3);
            String about =(String) listBD.get(4);
            */

        }
        cursor.close();
        return listBD;


        }catch (Exception e){
            Log.d("ОТЛАДКА ",e.toString());}
        return new ArrayList<>();
    }

    //
    public List<List> ListNameBDall(String search,String searchKEY){
        try{
            List<String> listBD = new ArrayList<>();
            List<List> listBDall = new ArrayList<>();
            Cursor cursor = db.query(
                    constantFMEECH.TABLE_NAME1,  // Таблица для запроса
                    null,               // Массив возвращаемых столбцов (передайте null, чтобы получить все)
                    null,               // Столбцы для предложения WHERE
                    null,            // Значения для предложения WHERE
                    null,               // не группировать строки
                    null,                // не фильтровать по группам строк
                    null                // Порядок сортировки
            );
            while (cursor.moveToNext()){
                Log.d("ОТЛАДКА (БД): ",(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ID)))+     " " +     (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_NAME)))+         " " +     (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN)))+           " " +   (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_PASS)))+         " " +     (cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ABOUT))));

                if(search.equals(cursor.getString(cursor.getColumnIndexOrThrow(searchKEY)))){
                    listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ID)));   //0
                    listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_NAME))); //1
                    listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN)));//2
                    listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_PASS))); //3
                    listBD.add(cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_ABOUT)));//4
                    listBDall.add(listBD);
                }
            /*
            Шаблон вытаскивания данных из листа
            String id =(String) listBD.get(0);
            String name =(String) listBD.get(1);
            String login =(String) listBD.get(2);
            String pass =(String) listBD.get(3);
            String about =(String) listBD.get(4);
            */

            }
            cursor.close();
            return listBDall;


        }catch (Exception e){
            Log.d("ОТЛАДКА ",e.toString());}
        return new ArrayList<>();
    }

    //Изменить в БД в таблице ЮЗЕР запись
    public void UpdateBD(String login, String pass,String name,String about){
        try {
            ContentValues values = new ContentValues();
            values.put(constantFMEECH.KEY_NAME, name);
            values.put(constantFMEECH.KEY_LOGIN, login);//значения.помещаются(КЛЮЧ_ЛОГИН, логин);
            values.put(constantFMEECH.KEY_PASS, pass);
            values.put(constantFMEECH.KEY_ABOUT, about);

            //бд.вставлять(ТАБЛИЦА_ЮЗЕР,Новый обьект для бд,По какому столбцу будет вестись поиск + "= ?",Массив элементов для условия поиска)
            db.update
                    (
                            constantFMEECH.TABLE_NAME1,
                            values,
                            constantFMEECH.KEY_LOGIN+"= ?",
                            new String[]{login}
                    );

            Log.d("ОТЛАДКА","В БД успешно были обновлены записи с логином: "+login);
        } catch (Exception e) {
            Log.d("ОТЛАДКА ",e.toString());
        }
    }


















    //Открыть доступ к БД
    public void openBD(){
        try {
            db=BDFmeech.getWritableDatabase();
            Log.d("ОТЛАДКА","Контроль над бд получен успешно.");
        } catch (Exception e) {
            Log.d("ОТЛАДКА",e.toString());
        }

    }

    //Закрыть БД
    public void closeBD(){
        try {
            BDFmeech.close();
        } catch (Exception e) {
            Log.d("ОТЛАДКА","Не успешное закрытие БД: "+e.toString());
        }

    }







    //Шаблон поиска данных в бд
    public void POISK(String login){

        Cursor cursor = db.query(
                constantFMEECH.TABLE_NAME1,                                                     // Таблица для запроса
                null,                                                                   // Массив возвращаемых столбцов (передай null, чтобы получить все)
                null,                                                                   // Столбцы для предложения WHERE
                null,                                                                // Значения для предложения WHERE
                null,                                                                   // не группировать строки
                null,                                                                    // не фильтровать по группам строк
                null                                                                    // Порядок сортировки
        );

        while (cursor.moveToNext()) {                                                           /*Заставить двигаться курсор по таблице в бд*/
            String a = cursor.getString(cursor.getColumnIndexOrThrow(constantFMEECH.KEY_LOGIN));/*Найти столбец в выданой строчке*/
        }

    }
}

