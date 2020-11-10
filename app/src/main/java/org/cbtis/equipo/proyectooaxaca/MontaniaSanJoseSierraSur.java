package org.cbtis.equipo.proyectooaxaca;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MontaniaSanJoseSierraSur extends Activity {
    MediaPlayer vMdpClick;
    Button vBtnUbicacion;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.san_jose_sierra_sur);
        vBtnUbicacion=(Button)findViewById(R.id.btnUbicacion);

        vBtnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vMdpClick=MediaPlayer.create(MontaniaSanJoseSierraSur.this,R.raw.blop);
                vMdpClick.start();
                Uri gmmIntentUri = Uri.parse("geo:16.169526,-96.502393?q=San+Jose+Del+Pacifico+Oaxaca+Mexico+San+Mateo+Rio+Hondo+México");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                try
                {
                    startActivity(mapIntent);
                }
                catch(ActivityNotFoundException innerEx) {
                    Toast.makeText(getBaseContext(), "Para utilizar esta funcion es necesario tener instalada la aplicacion Google Maps", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
