package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MA_A_04 extends AppCompatActivity {

    //ETIQUETA EXTRA PARA PASAR INFO A TODOS LOS ACTIVITYS
    static final String EXTRA_PROVINCIA = "PROVINCIA";

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    ListView list_lugaresa04;

    ///////////////////////////////////////////////////////

    //LLAMADA DE LA DATA BASE
    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ///////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__a_04);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        list_lugaresa04 = (ListView) findViewById(R.id.listlugaresa04);

        //DATOS A MOSTRAR EN EL LIST VIEW
        String[] provincias = {"A Coruña","Álava","Albacete","Alicante","Almería","Asturias",
                "Ávila", "Badajoz","Baleares","Barcelona","Burgos","Cáceres","Cádiz","Cantabria",
                "Castellón","Ciudad Real","Córdoba","Cuenca","Girona","Granada","Guadalajara",
                "Guipúzcoa","Huelva","Huesca","Jaén","La Rioja","Lleida","Lugo","Madrid","Málaga",
                "Murcia","Navarra","Ourense","Palencia","Las Palmas","Pontevedra","Salamanca",
                "Segovia","Sevilla","Soria","Tarragona","Tenerife","Pontevedra","Teruel","Toledo",
                "Valencia","Valladolid","Zamora","Zaragoza","Ceuta","Melilla"};

        ///////////////////////////////////////////////////////

        //CREAR EL ADAPATADOR
        ArrayAdapter<String> adapProvincias = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, provincias);

        //AÑADIR ADAPTADOR AL LIESTVIEW
        list_lugaresa04.setAdapter(adapProvincias);

        //CREAR EL CLICK EN LA LISTVIEW

        list_lugaresa04.setOnItemClickListener
                (new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    /*    //ETIQUETA DE LA CAJA DEL SPINNER (PROVINCIAS), IDENTIFICAR
                        String cajaslistprovincias = list_lugaresa04.getSelectedItem().toString();

                        //COGER REFERENCIA DATABASE
                        dbRef = FirebaseDatabase.getInstance().getReference()
                                .child("Usuarios"); //---COMO DECIR EN QUE PARAMETRO SE DEBE METER

                        //NUEVO VALOR
                        //STRING NUEVA CLASE
                        dbRef.child(cajanick).setValue(nuevoUsuario, new DatabaseReference.CompletionListener() {
                            public void onComplete(DatabaseError error, DatabaseReference ref) {
                                if (error == null) { */

                        //CREAR ETIQUETAS A LOS ELEMENTOS DE LA LISTVIEW

                        //REFERENCIA A LA CLASE + UNA LETRA
                        Class_Usuario p = ((Class_Usuario) parent.getItemAtPosition(position));

                        //ETIQUETA + INDICAR A QUE MAINACTIVITY VA A IR
                        Intent i = new Intent(getApplicationContext(), MA_A_05.class);

                      //DECIR QUE DATOS DEBE PASAR AL PRÓXIMO MAIN ACTIVITY (EXTRA CREAR EN ETIQUETAS)
 //                       i.putExtra(EXTRA_PROVINCIA, P);

                        //INICIAR ACTIVITY
                        startActivity(i);
                    }
                });



    }//FIN OVERRRIDE



}//FIN JAVA
