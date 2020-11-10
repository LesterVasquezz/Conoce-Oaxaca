package org.cbtis.equipo.proyectooaxaca;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;


public class PantallaDeBienvenida extends Activity {

        private static final long SPLASH_SCREEN_DELAY = 1000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Se establece la orientacion vertical por default
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            // se oculta la barra de titulo
             requestWindowFeature(Window.FEATURE_NO_TITLE);

            setContentView(R.layout.pantalla_de_bienvenida);

            TimerTask task = new TimerTask() {
                @Override
                public void run() {

                    // se va a la siguiente actividad
                    Intent mainIntent = new Intent().setClass(
                            PantallaDeBienvenida.this, MenuPrincipal.class);
                    startActivity(mainIntent);

                    finish();
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, SPLASH_SCREEN_DELAY);
        }

    }
