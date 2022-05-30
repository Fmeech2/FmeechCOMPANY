package com.example.fmeechcomopany;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//КЛАСС щаблона алерт диалога
public class al{
    //Шаблон алерт диалога
    public static void fmALERT(String тайтл,String сообщение,Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(тайтл);
        builder.setMessage(сообщение);
        builder.setCancelable(true);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Отпускает диалоговое окно
            }
        });
        builder.show();
    }

    //Шаблон Воремя сейчас метод
    public static String fmDATA(){
        // Текущее время
        Date currentDate = new Date();
        // Форматирование времени как "часы:минуты:секунды"
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);
        Log.d("ВРЕМЯ ",timeText);
        return timeText;
    }

}
