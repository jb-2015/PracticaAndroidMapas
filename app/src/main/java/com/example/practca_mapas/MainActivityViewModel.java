package com.example.practca_mapas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<MapaActual> mMapaActual;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<MapaActual> getMMapaActual(){
        if(mMapaActual==null){
            mMapaActual = new MutableLiveData<>();
        }
        return mMapaActual;
    }

    public void obtenerMapa(){
        MapaActual mapaActual = new MapaActual();
        mMapaActual.setValue(mapaActual);
    }

    public class MapaActual implements OnMapReadyCallback{
        LatLng SANLUIS=new LatLng(-33.2805576, -66.332482);
        LatLng ULP=new LatLng(-33.150720,-66.306864);
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            googleMap.addMarker(new MarkerOptions().position(SANLUIS).title("San Luis"));
            googleMap.addMarker(new MarkerOptions().position(ULP).title("ULP"));

            CameraPosition cameraPosition=
                    new CameraPosition.Builder()
                            .target(ULP)
                            .zoom(19)
                            .bearing(45)
                            .tilt(70)
                            .build();
            CameraUpdate cameraUpdate= CameraUpdateFactory.newCameraPosition(cameraPosition);

            googleMap.animateCamera(cameraUpdate);
        }
    }
}
