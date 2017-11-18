package org.example.amylipsky.myapplication;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//Google Maps Class
public class GoogleMaps extends AppCompatActivity implements OnMapReadyCallback {

    private static ArrayList<String> location_list = new ArrayList<>();
    private static ArrayList<String> courselist = new ArrayList<>();
    private static ArrayList<String> startlist = new ArrayList<>();
    private static ArrayList<String> endlist = new ArrayList<>();
    private static ArrayList<String> ppllist = new ArrayList<>();
    private static ArrayList<String> userCourses = new ArrayList<>();
    private static ArrayList<String> User = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_maps);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setTitle("StudyQuest");


        //ActionBar actionBar = getActionBar();
        //actionBar.setTitle("StudyQuest");

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        final String _User = currentUser.getUid(); //get Uid from Auth

        //gets the data from the database
        //  note, this happens after the first time the map is created
        //  to fix this just back out and then go back in
        FirebaseDatabase.getInstance().getReference().child("groups").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                location_list.clear();
                courselist.clear();
                startlist.clear();
                endlist.clear();
                ppllist.clear();
                User.clear();

                //iterate through all children of groups
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    //put each piece of data into the appropriate variable
                    String course = (String) snapshot.child("course").getValue();
                    String endtime = (String) snapshot.child("endtime").getValue();
                    String locations = (String) snapshot.child("locations").getValue();
                    String numppl = (String) snapshot.child("numppl").getValue();
                    String starttime = (String) snapshot.child("starttime").getValue();
                    String aUser = (String) snapshot.child("User").getValue();

                    //add each piece of data to the array list
                    location_list.add(locations);
                    courselist.add(course);
                    startlist.add(starttime);
                    endlist.add(endtime);
                    ppllist.add(numppl);
                    User.add(aUser);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FirebaseDatabase.getInstance().getReference().child("users").child(_User).child("Courses").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userCourses.clear();

                //iterate through the courses
                for(DataSnapshot snapshot: dataSnapshot.getChildren()) {

                    String theCourse = (String) snapshot.getKey();

                    userCourses.add(theCourse);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //delay the program for 5 seconds
        //  it takes a few sec to read from the database so hold your horses
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //build the actual map from google magic
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        //last line of google magic
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;

        double longitude;
        double lat;

        //zooms the map in on UB and sets boundries
        LatLng buffalo = new LatLng(43, -78.7865);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buffalo));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buffalo, 14));

        //used to create random number
        //  NOTE NOT SEEDED
        Random rand = new Random();

        //clear all the markers from the map
        mMap.clear();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        final String _User = currentUser.getUid(); //get Uid from Auth

        //creates a marker for every group
        for(int i = 0; i<location_list.size(); ++i) {

            if(location_list.get(i) != null) {

                //determines lat and lng for location
                //  NOTE, always goes to default for some reason
                if (location_list.get(i).equals("Capen")) {
                    longitude = -78.789966 + (-78.789202 + 78.789966) * rand.nextDouble();
                    lat = 43.000523 + (43.001268 - 43.000523) * rand.nextDouble();
                } else if (location_list.get(i).equals("Lockwood")) {
                    longitude = -78.786336 + (-78.785688 + 78.786336) * rand.nextDouble();
                    lat = 42.999886 + (43.000597 - 42.999886) * rand.nextDouble();
                } else //if (location_list.get(i)== "SU") {
                {
                    longitude = -78.786780 + (-78.785832 + 78.786780) * rand.nextDouble();
                    lat = 43.000867 + (43.001451 - 43.000867) * rand.nextDouble();
                }

                //set the temp lat and lng for the current marker
                LatLng temp = new LatLng(lat, longitude);


                String them = courselist.get(i) + "*****";

                them = them.toUpperCase();

                them = them.substring(0, 3);

                //iterate through all the user courses
                for (int j = 0; j < userCourses.size(); ++j) {


                    //compare if this user course is equal to the course of the marker
                    if (them.equals(userCourses.get(j))) {

                        //determine if the marker was made by the current user
                        if(_User.equals(User.get(i))){
                            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).position(temp).title(" ").snippet(
                                    location_list.get(i) + " " + courselist.get(i) + " " + startlist.get(i) + " " + endlist.get(i) + " " + ppllist.get(i)));
                        }
                        else{
                            //create the actual marker using provided info
                            mMap.addMarker(new MarkerOptions().position(temp).title(" ").snippet(
                                    location_list.get(i) + " " + courselist.get(i) + " " + startlist.get(i) + " " + endlist.get(i) + " " + ppllist.get(i)));
                        }
                    }

                }
            }
        }

    }

}