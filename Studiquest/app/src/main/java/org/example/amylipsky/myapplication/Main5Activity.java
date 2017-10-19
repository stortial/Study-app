package org.example.amylipsky.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
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
    private DatabaseReference parent;
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
    //ArrayList<String> locationlist = new ArrayList<String>();
    private ArrayList<String> location_list = new ArrayList<String>();
    private ArrayList<String> courselist = new ArrayList<String>();
    private ArrayList<String> startlist = new ArrayList<String>();
    private ArrayList<String> endlist = new ArrayList<String>();
    private ArrayList<String> ppllist = new ArrayList<String>();
    private ArrayList<Marker> theMarkers = new ArrayList<Marker>();
    private Handler UI_Handler = new Handler();

    private static final String TAG = "DataBase";

    private class Groupss{
        public String location;
        public String course;
        public String starttime;
        public String endtime;
        public String numppl;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        //parent = database.getReference("groups");



        FirebaseDatabase.getInstance().getReference().child("groups").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    System.out.println("ADAM"+snapshot.getKey());




                    //Group mgroup = snapshot.getValue(Group.class);
/*
                    location_list.add(mgroup.location);
                    courselist.add(mgroup.course);
                    startlist.add(mgroup.starttime);
                    endlist.add(mgroup.endtime);
                    ppllist.add(mgroup.numppl);

*/
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        //System.out.println("BEFORE THE FUNCTION");
        //database = FirebaseDatabase.getInstance();
        //locationmarkerRef = database.getReference("groups");
/*
        database = FirebaseDatabase.getInstance();
        groupRef = database.getReference("groups");
        groupKey = groupRef.push();
        groupID = groupKey.getKey();




        //database.


        groupRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getLocation = dataSnapshot.child("locations").getValue().toString();
                getCourse = dataSnapshot.child("course").getValue().toString();
                getStart = dataSnapshot.child("starttime").getValue().toString();
                getEnd = dataSnapshot.child("endtime").getValue().toString();
                getnumppl = dataSnapshot.child("numppl").getValue().toString();

                location_list.add(getLocation);
                courselist.add(getCourse);
                startlist.add(getStart);
                endlist.add(getEnd);
                ppllist.add(getnumppl);
                System.out.println("Location***** " + getLocation);
                System.out.println("course***** " + getCourse);
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

        });
        //System.out.println("HELLO" + locationkey.size());

  */  }



    private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.99262, -78.799561),
            new LatLng(43.012405, -78.770156));


    /*private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.975091,-78.806297),
            new LatLng(43.020720,-78.766133));*/


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {



        mMap = googleMap;

        mMap.setLatLngBoundsForCameraTarget(UniversityAtBuffalo);

        //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(UniversityAtBuffalo, 17));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UniversityAtBuffalo.getCenter(), 17));

        //LatLng test = new LatLng(43.001268, -78.789202);

        //Marker tester = mMap.addMarker(new MarkerOptions().position(test).title(" ").snippet("Capen CSE 3:00pm 6:00pm 5"));

        // Add a marker in Sydney and move the camera
        LatLng buffalo = new LatLng(43, -78.7865);
        //mMap.addMarker(new MarkerOptions().position(buffalo).title("Marker in Buffalo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buffalo));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buffalo, 14));

        //UI_Handler.postDelayed(UI_UPDATE_RUNNABLE, 5000);

        Random rand = new Random();
/*

        System.out.println("here********************************************************" + '\n');

        System.out.println(location_list.size());



        System.out.println("BEFORE THE FUNCTION");
        database = FirebaseDatabase.getInstance();
        locationmarkerRef = database.getReference("location marker");

        database = FirebaseDatabase.getInstance();
        groupRef = database.getReference("groups");
        groupKey = groupRef.push();
        groupID = groupKey.getKey();



        //database.

        groupRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getLocation = dataSnapshot.child("locations").getValue().toString();
                getCourse = dataSnapshot.child("course").getValue().toString();
                getStart = dataSnapshot.child("starttime").getValue().toString();
                getEnd = dataSnapshot.child("endtime").getValue().toString();
                getnumppl = dataSnapshot.child("numppl").getValue().toString();

                location_list.add(getLocation);
                courselist.add(getCourse);
                startlist.add(getStart);
                endlist.add(getEnd);
                ppllist.add(getnumppl);
                System.out.println("Location***** " + getLocation);
                System.out.println("course***** " + getCourse);
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

        });
*/


        for(int i = 0; i<location_list.size(); ++i) {

            System.out.println(location_list.get(i));

            if (location_list.get(i) == "Capen") {
             longitude = -78.789966 + (-78.789202 + 78.789966) * rand.nextDouble();
               lat = 43.000523 + (43.001268 - 43.000523) * rand.nextDouble();
             } else if (location_list.get(i)== "Lockwood") {
            longitude = -78.786336 + (-78.785688 + 78.786336) * rand.nextDouble();
              lat = 42.999886 + (43.000597 - 42.999886) * rand.nextDouble();
            } else if (location_list.get(i)== "SU") {
              longitude = -78.786780 + (-78.785832 + 78.786780) * rand.nextDouble();
               lat = 43.000867 + (43.001451 - 43.000867) * rand.nextDouble();
            }

            LatLng temp = new LatLng(lat, longitude);

            //here is where i add the actual stuff
            Marker test = mMap.addMarker(new MarkerOptions().position(temp).title(" ").snippet(
                    location_list.get(i)+" "+courselist.get(i)+" "+startlist.get(i)+" "+endlist.get(i)+" "+ ppllist.get(i)));

            theMarkers.add(test);
        }
    }




/*
    Runnable UI_UPDATE_RUNNABLE = new Runnable() {

        @Override
        public void run() {

            theMarkers.clear();

            Random rand = new Random();

            System.out.println(location_list.size());


            for(int i = 0; i<location_list.size(); ++i) {

                System.out.println(location_list.get(i));

                if (location_list.get(i) == "Capen") {
                    longitude = -78.789966 + (-78.789202 + 78.789966) * rand.nextDouble();
                    lat = 43.000523 + (43.001268 - 43.000523) * rand.nextDouble();
                } else if (location_list.get(i)== "Lockwood") {
                    longitude = -78.786336 + (-78.785688 + 78.786336) * rand.nextDouble();
                    lat = 42.999886 + (43.000597 - 42.999886) * rand.nextDouble();
                } else if (location_list.get(i)== "SU") {
                    longitude = -78.786780 + (-78.785832 + 78.786780) * rand.nextDouble();
                    lat = 43.000867 + (43.001451 - 43.000867) * rand.nextDouble();
                }

                LatLng temp = new LatLng(lat, longitude);

                //here is where i add the actual stuff
                Marker test = mMap.addMarker(new MarkerOptions().position(temp).title(" ").snippet(
                        getLocation+" "+getCourse+" "+getStart+" "+getEnd+" "+ getnumppl));

                theMarkers.add(test);

                }

            UI_Handler.postDelayed(UI_UPDATE_RUNNABLE, 30000);

        };


    };*/
}


