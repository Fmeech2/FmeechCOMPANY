package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fmeechcomopany.BDjavaFMEECH.interfaseFMEECH;

import java.util.ArrayList;
import java.util.List;

public class Friend extends AppCompatActivity {
    private interfaseFMEECH InterfaseFmeech;
    LinearLayout LISTARKio;
    List<String> Lacklist;
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
        setContentView(R.layout.activity_friend);
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
        LISTARKio=findViewById(R.id.LISTARKio);
        startAct();
    }

    public void Perhod(View view) {
        Intent abc = new Intent(this, your_profil.class);
        startActivity(abc);
    }

    //отображение сообщений
    public void startAct() {
        LISTARKio.removeAllViews();
        int a=0;

        try {
            while (a<30){
//Отображаёт и крашит нулёвые сообшения
                try {
                    String nameNOL =InterfaseFmeech.NameFRENDid(login,String.valueOf(a));
if(!nameNOL.equals("ЧЁ, НЕТ ИМЕНИ??")){
                    try {
                        LinearLayout Lost1 = new LinearLayout(this);
                        ImageView Img1 = new ImageView(this);
                        TextView TextTV = new TextView(this);
                        LinearLayout Lost2 = new LinearLayout(this);
                        LinearLayout ll = new LinearLayout(this);
                        ll.setOrientation(LinearLayout.VERTICAL);

                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        layoutParams.setMargins(0, 30, 0, 0);


                        LinearLayout llBTN = new LinearLayout(this);
                        llBTN.setOrientation(LinearLayout.VERTICAL);

                        LinearLayout.LayoutParams layoutParamsBTN = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        layoutParamsBTN.setMargins(10, 10, 10, 10);


                        try {
                            try {
                                Lost1.setOrientation(LinearLayout.HORIZONTAL);
                                Lost1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));//width,height
                                try {
                                    LinearLayout.LayoutParams Lost1Params = (LinearLayout.LayoutParams) Lost1.getLayoutParams();
                                    Lost1Params.topMargin = 40;
                                    Lost1.setLayoutParams(Lost1Params);
                                }
                                catch (Exception e){
                                    Log.d("ОТЛАДКА ОШИБКА 100",e.toString());
                                }

                            }
                            catch (Exception e){
                                Log.d("ОТЛАДКА ОШИБКА 4",e.toString());
                            }

                            Img1.setLayoutParams(new ViewGroup.LayoutParams(150,150));//width,height
                            Img1.setImageResource(R.drawable.avotiz);



                            TextTV.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));//width,height
                            TextTV.setText(nameNOL);
                            TextTV.setTextColor(getResources().getColor(R.color.black));
                            TextTV.setTextSize(32);




                            Lost2.setOrientation(LinearLayout.VERTICAL);
                            Lost2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));//width,height
                            LinearLayout.LayoutParams Lost2Params = (LinearLayout.LayoutParams) Lost2.getLayoutParams();
                            Lost2Params.leftMargin = 10;
                            Lost2.setLayoutParams(Lost2Params);


                        }
                        catch (Exception e){
                            Log.d("ОТЛАДКА ОШИБКА 2",e.toString());
                        }
                        try {
                            Lost2.addView(TextTV);
                            Lost2.addView(llBTN);
                            Lost1.addView(Img1);
                            Lost1.addView(Lost2);
                            ll.addView(Lost1, layoutParams);
                            LISTARKio.addView(ll);
                        }
                        catch (Exception e){
                            Log.d("ОТЛАДКА ОШИБКА 3",e.toString());
                        }
                    }
                    catch (Exception e){
                        Log.d("ОТЛАДКА ОШИБКА 1",e.toString());
                    }} }
                catch (Exception e){            Log.d("ОТЛАДКА"," Закрыть тупой цикл!!"+e.toString());}
                a++;
            }
        }
        catch (Exception e){            Log.d("ОТЛАДКА"," Закрыть тупой цикл!!"+e.toString());}


    }

    public void back(View view) {
        finish();
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
