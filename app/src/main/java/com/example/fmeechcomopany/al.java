package com.example.fmeechcomopany;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
}
