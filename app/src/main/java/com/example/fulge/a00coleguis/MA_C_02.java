package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MA_C_02 extends AppCompatActivity {

    //ETIQUETA EXTRA PARA PASAR INFO A TODOS LOS ACTIVITYS
    static final String EXTRA_EVENTO="EVENTO";

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    EditText et_nombrec02, et_fechac02, et_ciudadc02;
    Spinner spin_provinciasc02;

    ///////////////////////////////////////////////////////

    //VARIABLES OBJETO FIREBASE
    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ///////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__c_02);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        et_nombrec02 = (EditText) findViewById(R.id.etnombrec02);
        et_fechac02 = (EditText) findViewById(R.id.etfechac02);
        et_ciudadc02 = (EditText) findViewById(R.id.etciudadc02);
        spin_provinciasc02 = (Spinner) findViewById(R.id.spinprovinciasc02);

        //DATOS A MOSTRAR EN EL LIST VIEW
        String[] provincias = {"","A Coruña","Álava","Albacete","Alicante","Almería","Asturias",
                "Ávila", "Badajoz","Baleares","Barcelona","Burgos","Cáceres","Cádiz","Cantabria",
                "Castellón","Ciudad Real","Córdoba","Cuenca","Girona","Granada","Guadalajara",
                "Guipúzcoa","Huelva","Huesca","Jaén","La Rioja","Lleida","Lugo","Madrid","Málaga",
                "Murcia","Navarra","Ourense","Palencia","Las Palmas","Pontevedra","Salamanca",
                "Segovia","Sevilla","Soria","Tarragona","Tenerife","Pontevedra","Teruel","Toledo",
                "Valencia","Valladolid","Zamora","Zaragoza","Ceuta","Melilla"};

        //HACER EL ADAPTADOR SPINNER (PROVINCIA)
        ArrayAdapter<String> adapatadorProvincias = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, provincias);

        spin_provinciasc02.setAdapter(adapatadorProvincias);

        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////

    }//FIN OVERRRIDE

    //ACCIÓN BOTÓN DE ACCIÓN COMPROBAR
    public void clicksiguientea02 (View view) {

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (NICK), IDENTIFICAR
        String cajanombre = et_nombrec02.getText().toString();

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (FECHA), IDENTIFICAR
        String cajafecha = et_fechac02.getText().toString();

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (CIUDAD), IDENTIFICAR
        String cajaciudad = et_ciudadc02.getText().toString();

        //ETIQUETA DE LA CAJA DEL SPINNER (PROVINCIAS), IDENTIFICAR
        String cajaspinprovincias = spin_provinciasc02.getSelectedItem().toString();

        ///////////////////////////////////////////////////////

        //SI NO HAY CONTENIDO, APARECERÁ UN TOAST QUE INDIQUE QUE TIENE QUE RELLENAR LOS CAMPOS
        if (cajanombre.equals("") || cajafecha.equals("") || cajaciudad.equals("") || cajaspinprovincias.equals("")) {
            Toast.makeText(getApplicationContext(), "Debes rellenar todos los campos",
                    Toast.LENGTH_LONG).show();

            ///////////////////////////////////////////////////////
            //EN EL CASO QUE ESTEN RELLENOS LOS DATOS
        } else {

            //HAGO REFERENCIA A LA CLASE
            Class_Evento nuevoEvento = new Class_Evento(cajaciudad, cajafecha, cajanombre, cajaspinprovincias);

            //COGER REFERENCIA DATABASE
            dbRef = FirebaseDatabase.getInstance().getReference()
                    .child("Eventos");

            //NUEVO VALOR
            //STRING NUEVA CLASE
            dbRef.child(cajanombre).setValue(nuevoEvento, new DatabaseReference.CompletionListener() {
                public void onComplete(DatabaseError error, DatabaseReference ref) {
                    if (error == null) {

                        //ETIQUETA + INDICAR A QUE MAINACTIVITY VA A IR
                        Intent i = new Intent(getApplicationContext(), MA_B_04.class);

                        //INICIAR ACTIVITY
                        startActivity(i);
                    }


                }

            });
        }

    }
}//FIN JAVA
