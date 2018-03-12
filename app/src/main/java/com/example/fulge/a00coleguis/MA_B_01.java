package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MA_B_01 extends AppCompatActivity {

    //CABECERA

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    TextView tv_cabecerab01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__b_01);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        tv_cabecerab01 = (TextView) findViewById(R.id.tvcabecerab01);


    }//FIN OVERRRIDE

    //DECLARO BOTON
    public void clickmodificarperfilb01 (View view) {

        //IR A OTRO MAINACTIVITY
        Intent mainIntent = new Intent().setClass(getApplicationContext(), MA_A_02.class);
        startActivity(mainIntent);
        finish();


    }

    //DECLARO BOTON
    public void clickcreareventob01 (View view) {

        //IR A OTRO MAINACTIVITY
        Intent mainIntent = new Intent().setClass(getApplicationContext(), MA_C_01.class);
        startActivity(mainIntent);
        finish();


    }




}//FIN JAVA
