package org.cbtis.equipo.proyectooaxaca;
import android.content.Context;
import android.content.Intent;
import android.graphics.Region;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends AppCompatActivity {

    ManejadoraDeGaleria manejadorGaleria;
    ViewPager mViewPager;
    ListView vLstRegiones;
    Intent Intcamino;
    MediaPlayer vMdpClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        final String[] ARREGLOREGIONES = new String[]{
                "La Cañada",
                "La Mixteca",
                "El Istmo",
                "La costa",
                "Valles Centrales",
                "Sierra Norte",
                "Sierra Sur",
                "Papaloapan"
        };
        final int[] imagenes = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7,
                R.drawable.img8,
                R.drawable.img9
        };

        vLstRegiones = (ListView) findViewById(R.id.listViewRegiones);
        ArrayAdapter aryRegiones=new ArrayAdapter(this,android.R.layout.simple_list_item_1,ARREGLOREGIONES);
        vLstRegiones.setAdapter(aryRegiones);
        vLstRegiones.setSelected(false);

        //galeria de imagenes

        manejadorGaleria = new ManejadoraDeGaleria(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[0]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[1]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[2]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[3]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[4]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[5]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[6]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[7]));
        manejadorGaleria.agregarFragmentos(FragmentoImagenes.newInstance(imagenes[8]));
        mViewPager.setAdapter(manejadorGaleria);

        //Programacion Para pasar del menu a otras Actividades

        vLstRegiones.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                switch (arg2){
                    case 0:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,Caniada.class);
                        startActivity(Intcamino);
                        break;
                    case 1:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,Mixteca.class);
                        startActivity(Intcamino);
                        break;
                    case 2:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,Istmo.class);
                        startActivity(Intcamino);
                        break;
                    case 3:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,Costa.class);
                        startActivity(Intcamino);
                        break;
                    case 4:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,VallesCentrales.class);
                        startActivity(Intcamino);
                        break;
                    case 5:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,SierraNorte.class);
                        startActivity(Intcamino);
                        break;
                    case 6:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,SierraSur.class);
                        startActivity(Intcamino);
                        break;
                    case 7:
                        vMdpClick= MediaPlayer.create(MenuPrincipal.this,R.raw.pop);
                        vMdpClick.start();
                        Intcamino=new Intent(MenuPrincipal.this,Papaloapan.class);
                        startActivity(Intcamino);
                        break;

                }

            }

        });



    }
       public class ManejadoraDeGaleria extends FragmentPagerAdapter {
        List<Fragment> fragments;

        public ManejadoraDeGaleria(FragmentManager fm) {

            super(fm);
            fragments = new ArrayList<Fragment>();
        }

        public void agregarFragmentos(Fragment xfragmento) {
            fragments.add(xfragmento);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    public static class FragmentoImagenes extends Fragment {

        private static final String ARG_IMAGE = "imagen";
        private int imagen;

        public static FragmentoImagenes newInstance(int imagen) {
            FragmentoImagenes fragment = new FragmentoImagenes();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            return fragment;

        }

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                imagen = getArguments().getInt(ARG_IMAGE);
            }
        }

        public FragmentoImagenes() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_menu_principal, container, false);
            ImageView imagenView = (ImageView) rootView.findViewById(R.id.imageView);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }
}

