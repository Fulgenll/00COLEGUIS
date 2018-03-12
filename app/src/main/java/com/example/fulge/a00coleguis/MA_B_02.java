package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MA_B_02 extends AppCompatActivity {

    //ETIQUETA EXTRA PARA PASAR INFO A TODOS LOS ACTIVITYS
    static final String EXTRA_EVENTOSELECCIONADO = "EVENTOSELECCIONADO";

    //CABECERA
    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    TextView tv_cabecerab02, tv_cabeceraavatarb02;

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    ListView list_eventosb02;

    ///////////////////////////////////////////////////////

    //LLAMADA DE LA DATA BASE
    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ///////////////////////////////////////////////////////

    //DECLARAR Y HACER ETIQUETA DEL ADAPTADOR
    ArrayList<Class_Evento> lista_evento = new ArrayList<>();

    ///////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__b_02);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        list_eventosb02 = (ListView) findViewById(R.id.listeventosb02);
        tv_cabecerab02 = (TextView) findViewById(R.id.tvcabecerab02);
        tv_cabeceraavatarb02 = (TextView) findViewById(R.id.tvcabeceraavatarb02);

        ///////////////////////////////////////////////////////

        //CARGA DE LOS DATOS DE TODOS LOS DATOS
        cargarDatosFirebase();


    }//FIN OVERRRIDE

    ///////////////////////////////////////////////////////

    //BASE DE LIST VIEW
    private void cargarListView(DataSnapshot dataSnapshot) {

        //ENLAZAR DATOS FIREBASE
        lista_evento.add(dataSnapshot.getValue(Class_Evento.class));


        //RELACIONAR ADAPTADOR CON ETIQUETA
        Adaptador_Evento adaptadorEvento = new Adaptador_Evento(this,
                lista_evento);

        //RECOGER ADAPTADOR PARA LA LIST VIEW
        list_eventosb02.setAdapter(adaptadorEvento);

        ///////////////////////////////////////////////////////

        //CREAR EL CLICK CORTO EN LA LISTVIEW (QUE VA A IR A OTRA MAINACTIVITY)

        list_eventosb02.setOnItemClickListener
                (new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //REFERENCIA A LA CLASE + UNA LETRA
                        Class_Evento eventoseleccionado = ((Class_Evento) parent.getItemAtPosition(position));

                        //ETIQUETA + INDICAR A QUE MAINACTIVITY VA A IR
                        Intent i = new Intent(getApplicationContext(), MA_B_03.class);

                        //DECIR QUE DATOS DEBE PASAR AL PRÓXIMO MAIN ACTIVITY (EXTRA CREAR EN ETIQUETAS)
                        i.putExtra(EXTRA_EVENTOSELECCIONADO, eventoseleccionado);

                        //INICIAR ACTIVITY
                        startActivity(i);
                    }
                });
    }

    //METODO CARGAR UN DETERMINADO BASE DE DATOS DE FIREBASE
    private void cargarDatosFirebase() {

        //CARGAR UN DETERMINADO BASE DE DATOS DE FIREBASE
        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("Eventos"); //---------EVENTOS HIJO CATEGORIA----------

        //AÑADIMOS EL EVENTO QUE NOS DEVUELVE LOS VALORES
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //BORRAR DATOS
                lista_evento.clear();
                //DECIR QUE DATOS DEBE CARGAR
                for (DataSnapshot eventosDataSnapShot : dataSnapshot.getChildren()) {
                    cargarListView(eventosDataSnapShot);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("MainActivity", "DATABASE ERROR");

            }
        };

    }

}//FIN JAVA
