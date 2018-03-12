package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MA_A_02 extends AppCompatActivity {

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    EditText et_nicka02, et_edada02, et_maila02, et_passworda02, et_describetea02;
    CheckBox check_18a02, check_aceptoa02;

    ///////////////////////////////////////////////////////

    //VARIABLES OBJETO FIREBASE
    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ///////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__a_02);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        et_nicka02 = (EditText) findViewById(R.id.etnicka02);
        et_edada02 = (EditText) findViewById(R.id.etedada02);
        et_maila02 = (EditText) findViewById(R.id.etmaila02);
        et_passworda02 = (EditText) findViewById(R.id.etpassworda02);
        et_describetea02 = (EditText) findViewById(R.id.etdescribetea02);
        check_18a02 = (CheckBox) findViewById(R.id.check18a02);
        check_aceptoa02 = (CheckBox) findViewById(R.id.checkaceptoa02);

        ///////////////////////////////////////////////////////

    }//FIN OVERRRIDE

    ///////////////////////////////////////////////////////

    //DECLARO BOTON REGISTRARTE
    public void clickregistrartea02 (View view) {

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (MAIL), IDENTIFICAR
        final String cajamail = et_maila02.getText().toString();

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (NICK), IDENTIFICAR
        final String cajanick = et_nicka02.getText().toString();

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (CONTRASEÑA), IDENTIFICAR
        final String cajapassword = et_passworda02.getText().toString();

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (DESCRIPCIÓN), IDENTIFICAR
        final String cajadescribete = et_describetea02.getText().toString();

        //ETIQUETA DE LA CAJA DEL EDIT TEXT (EDAD OJO QUE ES INT), IDENTIFICAR
        final String cajaedad = et_edada02.getText().toString();

        ///////////////////////////////////////////////////////

        //SI NO HAY CONTENIDO, APARECERÁ UN TOAST QUE INDIQUE QUE TIENE QUE RELLENAR LOS CAMPOS
        if (cajamail.equals("") || cajanick.equals("") || cajapassword.equals("") || cajaedad.equals("") || cajadescribete.equals("")) {
            Toast.makeText(getApplicationContext(), "Los campos son obligatorios",
                    Toast.LENGTH_LONG).show();

            ///////////////////////////////////////////////////////

            //EN EL CASO QUE ESTEN RELLENOS LOS DATOS
        }else {

            //COMPROBAR QUE EL CHECKER (ACEPTAR LOS TERMINOS) ESTE ACTIVADO
            if (check_18a02.isChecked() && check_aceptoa02.isChecked()){

                //BUSCA EN LA BASE DE DATOS (PADRE + ETIQUETA DEL VALOR QUE BUSCA (NICK PARA VER SI ESTA REPETIDO)
                dbRef = FirebaseDatabase.getInstance().getReference().child("Usuarios/" + cajanick);

                //TRATA DE METER EL VALOR EN LA CLASE
                valueEventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Class_Usuario usu = dataSnapshot.getValue(Class_Usuario.class);
                        //VALOR USUARIO
                        String nickprueba = usu.getNick();

                        //NICK COMPARA SI ES IGUAL
                        if (cajanick.equals(nickprueba)) {

                            //TOAST SI ES IGUAL
                            Toast.makeText(getApplicationContext(), "Usuario ya registrado", Toast.LENGTH_SHORT).show();

                            ///////////////////////////////////////////////////////

                            //SI NO
                        } else {

                            //CONVERTIR PARCELABLE
                            int edadconvertida = Integer.parseInt(cajaedad);

                            //HAGO REFERENCIA A LA CLASE (HACER CONSTRUCTOR CON ÚNICAS VARIANTES Y ORDEN)
                            Class_Usuario nuevoUsuario = new Class_Usuario(cajadescribete, edadconvertida, cajamail, cajanick, cajapassword);

                            //COGER REFERENCIA DATABASE
                            dbRef = FirebaseDatabase.getInstance().getReference()
                                    .child("Usuarios");

                            //NUEVO VALOR
                            //STRING NUEVA CLASE
                            dbRef.child(cajanick).setValue(nuevoUsuario, new DatabaseReference.CompletionListener() {
                                public void onComplete(DatabaseError error, DatabaseReference ref) {
                                    if (error == null) {

                                        //ETIQUETA + INDICAR A QUE MAINACTIVITY VA A IR
                                        Intent i = new Intent(getApplicationContext(), MA_A_03.class);

                                        //INICIAR ACTIVITY
                                        startActivity(i);

                                        //SI NO, TOAST ERROR
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                "Datos no válidos o usuario ya registrado",
                                                Toast.LENGTH_LONG).show();

                                    }
                                }
                            });

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                };
            }else{
                Toast.makeText(getApplicationContext(), "Debes ser mayor de 18 y aceptar los terminos",
                        Toast.LENGTH_LONG).show();
            }



        }

    }
}//FIN JAVA