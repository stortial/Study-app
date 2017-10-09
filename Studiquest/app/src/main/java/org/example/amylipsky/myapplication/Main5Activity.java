package org.example.amylipsky.myapplication;


import java.util.Random;
import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;
import static org.example.amylipsky.myapplication.R.id.location;

//Google Maps Class
public class Main5Activity extends AppCompatActivity implements OnMapReadyCallback {

    private LocationRequest mLocationRequest;

    private long UPDATE_INTERVAL = 10 * 1000;
    private long FASTEST_INTERVAL = 2000;


    private GoogleMap mMap;
    private LocationManager locationManager;
    private String provider;

    private double lat;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);



/*        locationManager = (LocationManager) getSystemService((Context.LOCATION_SERVICE));


        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED ) {
            Criteria criteria = new Criteria();
            provider = locationManager.getBestProvider(criteria, false);
            Location location = locationManager.getLastKnownLocation(provider);

            lat = location.getLatitude();
            longitude = location.getLongitude();

        }*/
    }

    /*public static boolean checkPermission(Context context, String paramString)
    {
        PackageManager localPackageManager = context.getPackageManager();
        return localPackageManager.checkPermission(paramString, context.getPackageName()) == 0;
    }*/

    private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.99262, -78.799561),
            new LatLng(43.012405, -78.770156));

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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buffalo, 14));

        //-------------------------


        String mlocation = "Lockwood";

        for (int i = 0; i < 5; ++i) {

            String course = " ";

            String timeEnd= " ";

            String maxPpl= " ";

            //get the marker position
            Random rand = new Random();

            if (mlocation == "Capen") {
                longitude = -78.789966 + (-78.789202 + 78.789966) * rand.nextDouble();
                lat = 43.000523 + (43.001268 - 43.000523) * rand.nextDouble();
            } else if (mlocation == "Lockwood") {
                longitude = -78.786336 + (-78.785688 + 78.786336) * rand.nextDouble();
                lat = 42.999886 + (43.000597 - 42.999886) * rand.nextDouble();
            } else if (mlocation == "SU") {
                longitude = -78.786780 + (-78.785832 + 78.786780) * rand.nextDouble();
                lat = 43.000867 + (43.001451 - 43.000867) * rand.nextDouble();
            }
            LatLng loopPlace = new LatLng(lat, longitude);


            mMap.addMarker(new MarkerOptions().position(loopPlace)
                    .title(" ")
                    .snippet(course+"   "+timeEnd+"   "+maxPpl));

        }


    }

}