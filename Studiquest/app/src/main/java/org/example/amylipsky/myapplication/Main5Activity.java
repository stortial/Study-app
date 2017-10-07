package org.example.amylipsky.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
//Google Maps Class
public class Main5Activity extends AppCompatActivity implements OnMapReadyCallback{


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.99262,-78.799561),
            new LatLng(43.012405,-78.770156));


    /*private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.975091,-78.806297),
            new LatLng(43.020720,-78.766133));*/



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mMap.setLatLngBoundsForCameraTarget(UniversityAtBuffalo);

        //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(UniversityAtBuffalo, 17));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UniversityAtBuffalo.getCenter(), 17));



        // Add a marker in Sydney and move the camera
        LatLng buffalo = new LatLng(43, -78.7865);
        //mMap.addMarker(new MarkerOptions().position(buffalo).title("Marker in Buffalo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buffalo));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buffalo,14));


    }
}
