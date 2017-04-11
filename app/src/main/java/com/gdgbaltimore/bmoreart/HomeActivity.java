package com.gdgbaltimore.bmoreart;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.gdgbaltimore.bmoreart.MarkerData.MARKER_DATA;

public class HomeActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final LatLng[] BMORE_BOUNDRY = new LatLng[] {
        new LatLng(39.372264, -76.711529),
        new LatLng(39.372264, -76.529649),
        new LatLng(39.207672, -76.532966),
        new LatLng(39.197325, -76.550081),
        new LatLng(39.207578, -76.583704),
        new LatLng(39.234661, -76.611865),
        new LatLng(39.277896, -76.711035),
        new LatLng(39.372264, -76.711529),
    };

    private MarkerData[] markers = new MarkerData[] {
            new MarkerData(new LatLng(39.2818289, -76.584183), "OrderUp HQ", "Cody works here."),
            new MarkerData(new LatLng(39.408765, -76.596545), "Goucher College", "GDG Events happen here"),
            new MarkerData(new LatLng(39.3266504, -76.6048989), "Baltimore Museum of Art", "Great Art"),
    };

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

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.2904, -76.6122), 11));

        // Add at least 3 pins, maybe OrderUp HQ, Goucher College, pick a restaurant
        //Chose to add Baltimore Museum of Art(Dom)

        for (int i = 0; i < MARKER_DATA.length; i++) {
            googleMap.addMarker(createMapMarkerOptions(MARKER_DATA[i]));
        }

        googleMap.addPolyline(new PolylineOptions().add(BMORE_BOUNDRY)
                .width(5)
                .color(Color.RED));

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(HomeActivity.this, "Marker Clicked!", Toast.LENGTH_LONG).show();

                double lat = marker.getPosition().latitude;
                double lon = marker.getPosition().longitude;

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + lat + "," + lon));
                startActivity(intent);
            }
        });
    }

    private MarkerOptions createMapMarkerOptions(MarkerData markerData) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(markerData.position)
                .title(markerData.name)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))
                .snippet(markerData.snippet);

        return markerOptions;
    }
}
