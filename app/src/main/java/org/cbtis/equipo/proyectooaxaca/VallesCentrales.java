package org.cbtis.equipo.proyectooaxaca;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class VallesCentrales extends Activity {
    Spinner vSpnArtesanias,vSpnLugares;
    Intent vIntCamino;
    MediaPlayer vMdpClick;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu_vallescentrales);
        vSpnArtesanias=(Spinner)findViewById(R.id.spnArtesanias);
        vSpnLugares=(Spinner)findViewById(R.id.spnLugares);

        final String[]ARREGLOARTESANIAS=new String[]{
                "ARTESANIAS",
                "...",
                "Tejate Artesanal",
                "Ollas de Barro Negro"
        };
        final String[]ARREGLOLUGARES=new String[]{
                "LUGARES TURISTICOS",
                "...",
                "Catedral de Santo Domingo,",
                "Arbol del Tule"
        };
        ArrayAdapter<String> aryArtesanias=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ARREGLOARTESANIAS);
        aryArtesanias.setDropDownViewResource(android.R.layout.simple_spinner_item);
        vSpnArtesanias.setAdapter(aryArtesanias);
        vSpnArtesanias.setSelection(0);
        ArrayAdapter<String>aryLugares=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ARREGLOLUGARES);
        aryLugares.setDropDownViewResource(android.R.layout.simple_spinner_item);
        vSpnLugares.setAdapter(aryLugares);
        vSpnLugares.setSelection(0);

        vSpnArtesanias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case(2):
                        vMdpClick= MediaPlayer.create(VallesCentrales.this,R.raw.click);
                        vMdpClick.start();
                        Toast.makeText(getBaseContext(),"Momento porfavor",Toast.LENGTH_SHORT).show();
                        vIntCamino=new Intent(VallesCentrales.this,TejateVallesCentrales.class);
                        startActivity(vIntCamino);
                        break;
                    case(3):
                        vMdpClick= MediaPlayer.create(VallesCentrales.this,R.raw.click);
                        vMdpClick.start();
                        Toast.makeText(getBaseContext(),"Momento porfavor",Toast.LENGTH_SHORT).show();
                        vIntCamino=new Intent(VallesCentrales.this,OllasDeBarroNegroVallesCentrales.class);
                        startActivity(vIntCamino);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vSpnLugares.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case(2):
                        vMdpClick= MediaPlayer.create(VallesCentrales.this,R.raw.click);
                        vMdpClick.start();
                        Toast.makeText(getBaseContext(),"Momento porfavor",Toast.LENGTH_SHORT).show();
                        vIntCamino=new Intent(VallesCentrales.this,CatedralSantoDomingoVallesCentrales.class);
                        startActivity(vIntCamino);
                        break;
                    case(3):
                        vMdpClick= MediaPlayer.create(VallesCentrales.this,R.raw.click);
                        vMdpClick.start();
                        Toast.makeText(getBaseContext(),"Momento porfavor",Toast.LENGTH_SHORT).show();
                        vIntCamino=new Intent(VallesCentrales.this,ArbolDelTuleVallesCentrales.class);
                        startActivity(vIntCamino);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });








    }

}
