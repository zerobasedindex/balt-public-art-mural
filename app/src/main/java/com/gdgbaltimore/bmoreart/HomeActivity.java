package com.gdgbaltimore.bmoreart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Setup camera to point to baltimore
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.2904, -76.6122), 12));

        // Add at least 3 pins, maybe OrderUp HQ, Goucher College, and pick a restaurant
        googleMap.addMarker(new MarkerOptions().position(new LatLng(39.2818289, -76.584183)));

        // Draw a polyline around the Baltimore city boundry
        // You'll have to google to get lat/lon points for that boundry
    }
}
