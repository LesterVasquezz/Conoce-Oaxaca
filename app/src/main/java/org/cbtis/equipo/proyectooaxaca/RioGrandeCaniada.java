package org.cbtis.equipo.proyectooaxaca;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RioGrandeCaniada extends Activity {
    Button vBtnUbicacion;
    MediaPlayer vMdpClick;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rio_grande_caniada);
        vBtnUbicacion=(Button)findViewById(R.id.btnUbicacion);

        vBtnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vMdpClick= MediaPlayer.create(RioGrandeCaniada.this,R.raw.blop);
                vMdpClick.start();
                Uri gmmIntentUri = Uri.parse("geo:17.812963, -96.991159?q=Puente+Rio+Grande+San+Juan+Bautista+Cuiclatan+Oaxaca");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                try
                {
                    startActivity(mapIntent);
                }
                catch(ActivityNotFoundException innerEx) {
                    Toast.makeText(getBaseContext(),"Para utilizar esta funcion es necesario tener instalada la aplicacion Google Maps",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
