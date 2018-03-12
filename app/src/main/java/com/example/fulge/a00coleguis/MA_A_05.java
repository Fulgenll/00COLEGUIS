package com.example.fulge.a00coleguis;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MA_A_05 extends AppCompatActivity {

    //DECIR CUANTO VA A DURAR EL SPLASH SCREEN
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__a_05);

        //ORIENTACIÓN
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_ma__a_05);

        ///////////////////////////////////////////////////////

        //ACCION
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //COMIENZO DE LA SIGUIENTE ACTIVITY
                Intent mainIntent = new Intent().setClass(
                        getApplicationContext(), MA_B_01.class);
                startActivity(mainIntent);

                //DESTRUIR LA PANTALLA
                finish();
            }
        };

        ///////////////////////////////////////////////////////

        //CONTADOR
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    }//FINOverride

}//FINACTIVITY