package com.example.fmeechcomopany.BDjavaFMEECH;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDFmeech extends SQLiteOpenHelper {


    public BDFmeech(@Nullable Context context) {
        super(context, constantFMEECH.DATABASE_NAME, null, constantFMEECH.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(constantFMEECH.TABLE_STRUCTURE);
        db.execSQL(constantFMEECH.TABLE_STRUCTURE2);
        db.execSQL(constantFMEECH.TABLE_STRUCTURE3);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(constantFMEECH.DROP_TABLE1);
        db.execSQL(constantFMEECH.DROP_TABLE2);
        db.execSQL(constantFMEECH.DROP_TABLE3);
        onCreate(db);
    }
}
