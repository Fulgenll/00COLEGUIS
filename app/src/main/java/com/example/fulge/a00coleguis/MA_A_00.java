package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MA_A_00 extends AppCompatActivity {

    //DATOS QUE VIAJARAN ENTRE DISTINTAS MAINACTIVITY (LO ULTIMO)
    static final String EXTRA_USUARIO="USUARIO";

    //ETIQUETAS PARA LOS ELEMENTOS DEL LAYOUT
    EditText et_nick00, et_passworda00;

    ///////////////////////////////////////////////////////

    //VARIABLES OBJETO FIREBASE
       DatabaseReference dbRef;
      ValueEventListener valueEventListener;

    ///////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__a_00);

        //RELACIONAR ETIQUETAS CON ELEMENTOS
        et_passworda00 = (EditText) findViewById(R.id.etpassworda00);
        et_nick00 = (EditText) findViewById(R.id.etnick00);

        ///////////////////////////////////////////////////////

    }//FIN OVERRRIDE

    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////

    //DECLARO BOTON LOGUEARTE
    public void clicklogina00 (View view) {

            //ETIQUETA PARA RECOGER EDIT TEXT (NICK)
            String cajausuario = et_nick00.getText().toString();
            //ETIQUETA PARA RECOGER EDIT TEXT (CONTRASEÑA)
            final String cajapassword = et_passworda00.getText().toString();

             //BUSCA EN LA BASE DE DATOS (PADRE + ETIQUETA DEL VALOR QUE BUSCA (NICK))
            dbRef = FirebaseDatabase.getInstance().getReference().child("Usuarios/" + cajausuario);

            //TRATA DE METER EL VALOR EN LA CLASE
            valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    //TRATA DE VER SI EL VALOR ES VACIO
                    if (dataSnapshot.getValue() == null) {

                        //TOAST USUARIO INCORRECTO
                        Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();

                        //SI HAY
                    } else {
                        //BUSCAR EN CLASE USUARIO
                        Class_Usuario usu = dataSnapshot.getValue(Class_Usuario.class);
                        //VALOR CONTRASEÑA
                        String password = usu.getPassword();


                        //PASSWORD COMPARA SI ES DIFERENTE
                        if (!cajapassword.equals(password)) {

                            //TOAST SI ES DIFETENTE
                            Toast.makeText(getApplicationContext(), "Password incorrecto", Toast.LENGTH_SHORT).show();

                        //SI NO
                        } else {

                            Intent mainIntent = new Intent().setClass(getApplicationContext(), MA_B_01.class);
                            startActivity(mainIntent);
                            finish();

                        }
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("LoginActivity", "DATABASE ERROR");
                }
            };
            dbRef.addValueEventListener(valueEventListener);


        }

    //DECLARO BOTON LOGUEARTE
    public void clickregistrartea00 (View view) {
        Intent mainIntent = new Intent().setClass(getApplicationContext(), MA_A_02.class);
        startActivity(mainIntent);
    }


    ///////////////////////////////////////////////////////

}//FIN JAVA
