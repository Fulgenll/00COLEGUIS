package com.example.fulge.a00coleguis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MA_B_04 extends AppCompatActivity {

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    TextView tv_descripcionb04, tv_cabeceraeventorb04, tv_edadb04, tv_gustosb04;

    ///////////////////////////////////////////////////////

    //VARIABLES OBJETO FIREBASE
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;

    ///////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__b_04);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        tv_descripcionb04 = (TextView) findViewById(R.id.tvdescripcionb04);
        tv_cabeceraeventorb04 = (TextView) findViewById(R.id.tvcabeceraeventorb04);
        tv_edadb04 = (TextView) findViewById(R.id.tvedadb04);
        tv_gustosb04 = (TextView) findViewById(R.id.tvgustosb04);

        ///////////////////////////////////////////////////////

        //RECOGER RECURSOS DE OTROS ACTIVITYS
        Bundle b = getIntent().getExtras();

        //RECOGER INFORMACIÓN CONCRETA DE OTRO ACTIVITY
        if (b != null) {
            //RECOGER INFORMACIÓN DE TODOS LOS ACTIVITY (EXTRA_USUARIO)
            Class_Usuario u = b.getParcelable(MA_B_03.EXTRA_USUARIO);

        /*    //COLOCAR INFORMACION RECOGIDA (TEXT VIEW)
            tv_descripcionb04.setText(u.getDescripcion());
            tv_cabeceraeventorb04.setText(u.getNick());
            tv_edadb04.setText(u.getEdad());
            tv_gustosb04.setText(u.getGustos()); */
        }
    }

    ///////////////////////////////////////////////////////


    }//FIN OVERRRIDE

    //////////////////////////////////////////////////////

//FIN JAVA
