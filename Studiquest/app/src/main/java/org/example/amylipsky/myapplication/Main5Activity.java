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
<<<<<<< HEAD

=======
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
>>>>>>> 40de32eca3915f322ff579edb9c6b2f67346040a
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
<<<<<<< HEAD
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//Google Maps Class
public class Main5Activity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private String val;
    private FirebaseDatabase database;
    private DatabaseReference locationmarkerRef;
    private DatabaseReference locationmarkerChildRef;

    private FirebaseDatabase Mydatabase;
    private DatabaseReference groupRef;
    private DatabaseReference groupKey;
    private String getLocation;
    private String getCourse;
    private String getStart;
    private String getEnd;
    private String getnumppl;
    private String groupID;

    private double longitude = 0;
    private double lat = 0;
    ArrayList<String> locationkey = new ArrayList<String>();
    ArrayList<String> locationlist = new ArrayList<String>();

    private static final String TAG = "DataBase";
=======
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
>>>>>>> 40de32eca3915f322ff579edb9c6b2f67346040a

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

<<<<<<< HEAD
        System.out.println("BEFORE THE FUNCTION");
        database = FirebaseDatabase.getInstance();
        locationmarkerRef = database.getReference("location marker");

        database = FirebaseDatabase.getInstance();
        groupRef = database.getReference("groups");
        groupKey = groupRef.push();
        groupID = groupKey.getKey();



        groupRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               /* getLocation = dataSnapshot.child(groupID).child("locations");
               getCourse = dataSnapshot.child("course").getValue().toString();
                getStart = dataSnapshot.child("starttime").getValue().toString();
                getEnd = dataSnapshot.child("endtime").getValue().toString();
                getnumppl = dataSnapshot.child("numppl").getValue().toString();*/
                //System.out.println("LOCATION****"+getLocation);
                /*System.out.println("COURSE" + getCourse);
                System.out.println("START" + getStart);
                System.out.println("END" + getEnd);
                System.out.println("NUM" + getnumppl);*/



                //get the marker position
                Random rand = new Random();

                if (getLocation == "Capen") {
                    longitude = -78.789966 + (-78.789202 + 78.789966) * rand.nextDouble();
                    lat = 43.000523 + (43.001268 - 43.000523) * rand.nextDouble();
                } else if (getLocation == "Lockwood") {
                    longitude = -78.786336 + (-78.785688 + 78.786336) * rand.nextDouble();
                    lat = 42.999886 + (43.000597 - 42.999886) * rand.nextDouble();
                } else if (getLocation == "SU") {
                    longitude = -78.786780 + (-78.785832 + 78.786780) * rand.nextDouble();
                    lat = 43.000867 + (43.001451 - 43.000867) * rand.nextDouble();
                }
                LatLng loopPlace = new LatLng(lat, longitude);


                mMap.addMarker(new MarkerOptions().position(loopPlace)
                        .title(" ")
                        .snippet(getCourse+"   "+getStart+"   "+getEnd+"   "+getnumppl));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       /* locationmarkerRef.orderByKey().addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               locationkey.add(dataSnapshot.getKey());
                System.out.println("******"+locationkey.size());


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebaselocationmarker", "failed");
            }

        });*/
        System.out.println("HELLO" + locationkey.size());

        /*Iterator<String> it = locationkey.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for(int j=0; j<=locationkey.size(); ++j)
        {
            System.out.println("IN LOOP");

            System.out.println(locationkey.size());
            String temptemp = locationkey.toString();
            System.out.println(temptemp);
        }*/


        /*for(int i=0; i<=locationkey.size(); i++){
            System.out.println("CHILD BLA BLA");
            String stringlocationkey = locationkey.get(0);
            System.out.println(stringlocationkey);
            locationmarkerChildRef = database.getReference("location marker").child(stringlocationkey);
            System.out.println("CHILD BLA");
            locationmarkerChildRef.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    System.out.println(value);
                    locationlist.add(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });*/




        }


      /*  for(int i=0; i<3; i++){
            String temp = locationlist.get(i);
            System.out.println(temp);
        }
    }*/

    private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.99262, -78.799561),
            new LatLng(43.012405, -78.770156));
=======
>>>>>>> 40de32eca3915f322ff579edb9c6b2f67346040a


/*        locationManager = (LocationManager) getSystemService((Context.LOCATION_SERVICE));


        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED ) {
            Criteria criteria = new Criteria();
            provider = locationManager.getBestProvider(criteria, false);
            Location location = locationManager.getLastKnownLocation(provider);

<<<<<<< HEAD
=======
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

>>>>>>> 40de32eca3915f322ff579edb9c6b2f67346040a
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

<<<<<<< HEAD

=======
>>>>>>> 40de32eca3915f322ff579edb9c6b2f67346040a
        // Add a marker in Sydney and move the camera
        LatLng buffalo = new LatLng(43, -78.7865);
        //mMap.addMarker(new MarkerOptions().position(buffalo).title("Marker in Buffalo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buffalo));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buffalo, 14));
<<<<<<< HEAD
=======

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
>>>>>>> 40de32eca3915f322ff579edb9c6b2f67346040a


    }

<<<<<<< HEAD

}
=======
}
>>>>>>> 40de32eca3915f322ff579edb9c6b2f67346040a
