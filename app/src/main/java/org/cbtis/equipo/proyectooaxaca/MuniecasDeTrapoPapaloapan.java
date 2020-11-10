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

public class MuniecasDeTrapoPapaloapan extends Activity {
    MediaPlayer vMdpClick;
    Button vBtnUbicacion;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muniecas_de_trapo_papaloapan);
        vBtnUbicacion=(Button)findViewById(R.id.btnUbicacion);

        vBtnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vMdpClick=MediaPlayer.create(MuniecasDeTrapoPapaloapan.this,R.raw.blop);
                vMdpClick.start();
                Uri gmmIntentUri = Uri.parse("geo:18.080596,-96.122211?q=mercado+central+en+Tuxtepec+Oaxaca");
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
