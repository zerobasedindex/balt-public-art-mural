package com.gdgbaltimore.bmoreart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.gdgbaltimore.bmoreart.R.id.map;

public class HomeActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Setup camera to point to baltimore
        // Changed zoom to 11 from 12(Dom)
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.2904, -76.6122), 11));

        // Add at least 3 pins, maybe OrderUp HQ, Goucher College, pick a restaurant
        //Chose to add Baltimore Museum of Art(Dom)
        googleMap.addMarker(new MarkerOptions().position(new LatLng(39.2818289, -76.584183)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(39.408765, -76.596545)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(39.3266504, -76.6048989)));


        // Draw a polyline around the Baltimore city boundry
        // You'll have to google to get lat/lon points for that boundry

        Polyline line = googleMap.addPolyline(new PolylineOptions().add(new LatLng(39.372264, -76.711529), new LatLng(39.372264, -76.529649), new LatLng(39.207672, -76.532966),
                new LatLng(39.197325, -76.550081), new LatLng(39.207578, -76.583704), new LatLng(39.234661, -76.611865), new LatLng(39.277896, -76.711035), new LatLng(39.372264, -76.711529))
                .width(5)
                .color(Color.RED));

    }

}
