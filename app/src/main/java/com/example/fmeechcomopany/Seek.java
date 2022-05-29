package com.example.fmeechcomopany;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import com.example.fmeechcomopany.BDjavaFMEECH.constantFMEECH;
import com.example.fmeechcomopany.BDjavaFMEECH.interfaseFMEECH;

import java.util.ArrayList;
import java.util.List;


public class Seek extends AppCompatActivity {
    private interfaseFMEECH InterfaseFmeech;
    List<String> list =new ArrayList<>();
    String id,login,pass,name,about;

    EditText search_text;
    String search;
    LinearLayout Lost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_seek);
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


        Lost=findViewById(R.id.Lost);
        search_text=findViewById(R.id.search_text);
    }

    public void back4(View view) {
        finish();
    }

    public void profol(View view) {
        Intent abc = new Intent(this, your_profil.class);
        startActivity(abc);
    }

    public void serch(View view) {
        Lost.removeAllViews();



        search=search_text.getText().toString();
        List<String> Lacklist;
        List<List> Golist;
        Golist = InterfaseFmeech.ListNameBDall(search, constantFMEECH.KEY_NAME);
        int a=0;
        try {
            while (true){
                Lacklist=Golist.get(a);
                String name =(String) Lacklist.get(1);


                try {
                    LinearLayout Lost1 = new LinearLayout(this);
                    ImageView Img1 = new ImageView(this);
                    TextView TextTV = new TextView(this);
                    Button Btn1 = new Button(this);
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
                            Lost1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));//width,height
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

                        Img1.setLayoutParams(new LayoutParams(150,150));//width,height
                        Img1.setImageResource(R.drawable.avotiz);



                        TextTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));//width,height
                        TextTV.setText(name);
                        TextTV.setTextColor(getResources().getColor(R.color.black));
                        TextTV.setTextSize(18);



                        Btn1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));//width,height
                        Btn1.setText("Перейти в профиль");



                        Lost2.setOrientation(LinearLayout.VERTICAL);
                        Lost2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));//width,height
                        LinearLayout.LayoutParams Lost2Params = (LinearLayout.LayoutParams) Lost2.getLayoutParams();
                        Lost2Params.leftMargin = 10;
                        Lost2.setLayoutParams(Lost2Params);


                    }
                    catch (Exception e){
                        Log.d("ОТЛАДКА ОШИБКА 2",e.toString());
                    }
                    try {
                        Lost2.addView(TextTV);
                        llBTN.addView(Btn1, layoutParamsBTN);
                        Lost2.addView(llBTN);
                        Lost1.addView(Img1);
                        Lost1.addView(Lost2);
                        ll.addView(Lost1, layoutParams);
                        Lost.addView(ll);
                    }
                    catch (Exception e){
                        Log.d("ОТЛАДКА ОШИБКА 3",e.toString());
                    }
                }
                catch (Exception e){
                    Log.d("ОТЛАДКА ОШИБКА 1",e.toString());
                }
                a++;
            }
        }
        catch (Exception e){            Log.d("ОТЛАДКА"," Закрыть тупой цикл!!");}


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
