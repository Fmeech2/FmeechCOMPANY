package com.example.fmeechcomopany.BDjavaFMEECH;

public class constantFMEECH {

    public static final String TABLE_NAME1 = "user";
    public static final String KEY_ID = "id";
    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASS = "password";
    public static final String KEY_NAME = "name";
    public static final String KEY_ABOUT = "about";




    public static final String DATABASE_NAME = "FmeechCompany.db";
    public static final int DATABASE_VERSION = 9;

    public static final String TABLE_STRUCTURE =
            "CREATE TABLE " + TABLE_NAME1+
                    "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_NAME + " TEXT,"
                    + KEY_LOGIN + " TEXT,"
                    + KEY_PASS + " TEXT,"
                    + KEY_ABOUT + " TEXT"
                    +")";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME1;
}
//  Log.d("ОТЛАДКА ",e.toString());