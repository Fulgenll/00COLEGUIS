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

public class MA_B_03 extends AppCompatActivity {

    //ETIQUETA EXTRA PARA PASAR INFO A TODOS LOS ACTIVITYS
    static final String EXTRA_USUARIO = "USUARIO";

    //CABECERA
    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    TextView tv_cabeceraavatarb03, tv_cabecerab03;

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    ListView list_usuariosb03;

    ///////////////////////////////////////////////////////

    //LLAMADA DE LA DATA BASE
    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    //DECLARAR Y HACER ETIQUETA DEL ADAPTADOR
    ArrayList<Class_Usuario> lista_usuario = new ArrayList<>();

    ///////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__b_03);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        list_usuariosb03 = (ListView) findViewById(R.id.listusuariosb03);
        tv_cabecerab03 = (TextView) findViewById(R.id.tvcabecerab03);
        tv_cabeceraavatarb03 = (TextView) findViewById(R.id.tvcabeceraavatarb03);

        //RECOGER RECURSOS DE OTROS ACTIVITYS
        Bundle b = getIntent().getExtras();

        //RECOGER INFORMACIÓN CONCRETA DE OTRO ACTIVITY
        if (b != null) {
            //RECOGER INFORMACIÓN DE TODOS LOS ACTIVITY (EXTRA_RESERVA)
            Class_Evento eventoseleccionado = b.getParcelable(MA_B_02.EXTRA_EVENTOSELECCIONADO);

            //COLOCAR INFORMACION RECOGIDA (TEXT VIEW)
            tv_cabecerab03.setText(eventoseleccionado.getNombre());
        }

    ///////////////////////////////////////////////////////

        //CARGA DE LOS DATOS DE TODOS LOS DATOS
        cargarDatosFirebase();

    }//FIN OVERRRIDE

    ///////////////////////////////////////////////////////

    //BASE DE LIST VIEW
    private void cargarListView(DataSnapshot dataSnapshot) {

        //ENLAZAR DATOS FIREBASE
        lista_usuario.add(dataSnapshot.getValue(Class_Usuario.class));


        //RELACIONAR ADAPTADOR CON ETIQUETA
        Adaptador_Usuario adaptadorUsuario = new Adaptador_Usuario(this,
                lista_usuario);

        //RECOGER ADAPTADOR PARA LA LIST VIEW
        list_usuariosb03.setAdapter(adaptadorUsuario);

        ///////////////////////////////////////////////////////

        //CREAR EL CLICK CORTO EN LA LISTVIEW (QUE VA A IR A OTRA MAINACTIVITY)

        list_usuariosb03.setOnItemClickListener
                (new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //CREAR ETIQUETAS A LOS ELEMENTOS DE LA LISTVIEW

                        //REFERENCIA A LA CLASE + UNA LETRA
                        Class_Usuario u = ((Class_Usuario) parent.getItemAtPosition(position));

                        //ETIQUETA + INDICAR A QUE MAINACTIVITY VA A IR
                        Intent i = new Intent(getApplicationContext(), MA_B_03.class);

                        //DECIR QUE DATOS DEBE PASAR AL PRÓXIMO MAIN ACTIVITY (EXTRA CREAR EN ETIQUETAS)
                        i.putExtra(EXTRA_USUARIO, u);

                        //INICIAR ACTIVITY
                        startActivity(i);
                    }
                });
    }

    //METODO CARGAR UN DETERMINADO BASE DE DATOS DE FIREBASE
    private void cargarDatosFirebase() {

        //CARGAR UN DETERMINADO BASE DE DATOS DE FIREBASE
        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("Usuarios"); //---------EVENTOS HIJO CATEGORIA----------

        //AÑADIMOS EL EVENTO QUE NOS DEVUELVE LOS VALORES
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //BORRAR DATOS
                lista_usuario.clear();
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
