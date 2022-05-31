package com.example.fmeechcomopany.BDjavaFMEECH;

public class constantFMEECH {

    public static final String TABLE_NAME1 = "user";
    public static final String TABLE_NAME2 = "frend";
    public static final String TABLE_NAME3 = "messege";
    public static final String KEY_ID = "id";
    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASS = "password";
    public static final String KEY_NAME = "name";
    public static final String KEY_ABOUT = "about";

    public static final String KEY_ID1 = "id1";
    public static final String KEY_ID2 = "id2";
    public static final String KEY_LOGIN1 = "login1";
    public static final String KEY_LOGIN2 = "login2";
    public static final String KEY_MESSEGE = "messege";
    public static final String KEY_DATA = "data";



    public static final String DATABASE_NAME = "FmeechCompany.db";
    public static final int DATABASE_VERSION = 14;

    public static final String TABLE_STRUCTURE =
            "CREATE TABLE " + TABLE_NAME1+
                    "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_NAME + " TEXT,"
                    + KEY_LOGIN + " TEXT,"
                    + KEY_PASS + " TEXT,"
                    + KEY_ABOUT + " TEXT"
                    +")";

    public static final String TABLE_STRUCTURE2 =
            "CREATE TABLE " + TABLE_NAME2+
                    "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_LOGIN1 + " TEXT,"
                    + KEY_LOGIN2 + " TEXT"
                    +")";

    public static final String TABLE_STRUCTURE3 =
            "CREATE TABLE " + TABLE_NAME3+
                    "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_ID1 + " TEXT,"
                    + KEY_ID2 + " TEXT,"
                    + KEY_NAME + " TEXT,"
                    + KEY_MESSEGE + " TEXT,"
                    + KEY_DATA + " TEXT"
                    +")";

    public static final String DROP_TABLE1 =
            "DROP TABLE IF EXISTS " + TABLE_NAME1;
    public static final String DROP_TABLE2 =
            "DROP TABLE IF EXISTS " + TABLE_NAME2;
    public static final String DROP_TABLE3 =
            "DROP TABLE IF EXISTS " + TABLE_NAME3;
}
//  Log.d("ОТЛАДКА ",e.toString());