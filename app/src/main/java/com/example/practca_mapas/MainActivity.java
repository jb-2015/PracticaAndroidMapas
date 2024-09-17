package com.example.practca_mapas;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends FragmentActivity {
 private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        mv.getMMapaActual().observe(this, new Observer<MainActivityViewModel.MapaActual>() {
            @Override
            public void onChanged(MainActivityViewModel.MapaActual mapaActual) {

                ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(mapaActual);
            }
        });

        mv.obtenerMapa();
    }
}