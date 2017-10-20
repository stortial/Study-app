package org.example.amylipsky.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
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
    private static ArrayList<String> location_list = new ArrayList<String>();
    private static ArrayList<String> courselist = new ArrayList<String>();
    private static ArrayList<String> startlist = new ArrayList<String>();
    private static ArrayList<String> endlist = new ArrayList<String>();
    private static ArrayList<String> ppllist = new ArrayList<String>();

    //creates the map if it hasnt been initialized already
    private void mapSetup(){
        if (mMap == null){
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);

            mapFragment.getMapAsync(this);
        }
    }

    //creates the bounds for both the center of the map and the bounds
    private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.99262, -78.799561),
            new LatLng(43.012405, -78.770156));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        //gets the data from the database
        //  note, this happens after the first time the map is created
        //  to fix this just back out and then go back in
        FirebaseDatabase.getInstance().getReference().child("groups").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //iterate through all children of groups
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    System.out.println("MELL"+snapshot.getKey());

                    //put each piece of data into the appropriate variable
                    String course = (String) snapshot.child("course").getValue();
                    String endtime = (String) snapshot.child("endtime").getValue();
                    String locations = (String) snapshot.child("locations").getValue();
                    String numppl = (String) snapshot.child("numppl").getValue();
                    String starttime = (String) snapshot.child("starttime").getValue();

                    //add each piece of data to the array list
                    location_list.add(locations);
                    courselist.add(course);
                    startlist.add(starttime);
                    endlist.add(endtime);
                    ppllist.add(numppl);

                    System.out.println("DANDAN***"+location_list.size());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mapSetup();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //mMap.setLatLngBoundsForCameraTarget(UniversityAtBuffalo);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UniversityAtBuffalo.getCenter(), 17));


        LatLng buffalo = new LatLng(43, -78.7865);
        //mMap.addMarker(new MarkerOptions().position(buffalo).title("Marker in Buffalo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buffalo));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buffalo, 14));

        Random rand = new Random();


        //clear all the markers from the map
        //mMap.clear();

        for(int i = 0; i<location_list.size(); ++i) {

            System.out.println("ADAM"+location_list.get(i));

            if (location_list.get(i) == "Capen") {
                 longitude = -78.789966 + ( -78.789202 + 78.789966) * rand.nextDouble();
                 lat = 43.000523 + (43.001268 - 43.000523) * rand.nextDouble();
             }
            else if (location_list.get(i)== "Lockwood") {
                longitude = -78.786336 + ( -78.785688+ 78.786336 ) * rand.nextDouble();
                lat = 42.999886 + (43.000597 - 42.999886) * rand.nextDouble();
            }
            else //(location_list.get(i)== "SU") {
            {
                longitude = -78.786780 + ( -78.785832 + 78.786780) * rand.nextDouble();
                lat = 43.000867 + (43.001451 - 43.000867) * rand.nextDouble();
            }

            //set the temp lat and lng for the current marker
            LatLng temp = new LatLng(lat, longitude);

            System.out.println("AdAM"+lat+" "+longitude);

            //here is where i add the actual stuff
            mMap.addMarker(new MarkerOptions().position(temp).title(" ").snippet(
                    location_list.get(i)+" "+courselist.get(i)+" "+startlist.get(i)+" "+endlist.get(i)+" "+ ppllist.get(i)));

        }

    }

    //recreate the map, but this is done with the static array lists
    @Override
    public void onResume(){
        super.onResume();
        mapSetup();
    }

}


