package com.example.owl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends AppCompatActivity implements OnMapReadyCallback {

    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        this.latitude = -21.1875179;
        this.longitude = -47.8336921;
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(
                new LatLng(this.latitude, this.longitude),
                16
        );

        googleMap.addMarker(new MarkerOptions().position(new LatLng(this.latitude, this.longitude)).title("Estou aqui!"));
        googleMap.moveCamera(cam);
        googleMap.animateCamera(cam);
    }
}


