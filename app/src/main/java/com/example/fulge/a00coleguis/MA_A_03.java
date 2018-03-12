package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MA_A_03 extends AppCompatActivity {

    //DATOS QUE VIAJARAN ENTRE DISTINTAS MAINACTIVITY (LO ULTIMO)
    static final String EXTRA_GUSTOS="GUSTOS";

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    CheckBox check_gusto25a03, check_gusto26a03, check_gusto27a03, check_gusto22a03, check_gusto23a03, check_gusto24a03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__a_03);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        check_gusto25a03 = (CheckBox) findViewById(R.id.checkgusto25a03);
        check_gusto26a03 = (CheckBox) findViewById(R.id.checkgusto26a03);
        check_gusto27a03 = (CheckBox) findViewById(R.id.checkgusto27a03);
        check_gusto22a03 = (CheckBox) findViewById(R.id.checkgusto22a03);
        check_gusto23a03 = (CheckBox) findViewById(R.id.checkgusto23a03);
        check_gusto24a03 = (CheckBox) findViewById(R.id.checkgusto24a03);


    }//FIN OVERRRIDE


}//FIN JAVA
