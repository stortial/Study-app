package org.example.amylipsky.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseUser;

import static android.R.id.message;
import static org.example.amylipsky.myapplication.R.id.StudentUnion;
import static org.example.amylipsky.myapplication.R.id.button4;


public class Main6Activity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference groupRef;
    private DatabaseReference groupKey;
    private DatabaseReference initialize;
    private DatabaseReference initializelocation;
    private DatabaseReference locationKey;
    private DatabaseReference locationMarker;
    private String locationID;


    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText _Course;
    private EditText _StartTime;
    private EditText _EndTime;
    private EditText _NumberOfPeople;
    private String groupID;
    private static final String TAG = "DataBase";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        _Course = (EditText) findViewById(R.id.editText10);
        _StartTime = (EditText) findViewById(R.id.editText12);
        _EndTime = (EditText) findViewById(R.id.editText2);
        _NumberOfPeople = (EditText) findViewById(R.id.numerofppl);
        Button buttonAddGroup = (Button) findViewById(R.id.AddGroup);

        database = FirebaseDatabase.getInstance();
        initialize = database.getReference("groups").child("Initialize Group");
        initialize.setValue("true");
        groupRef = database.getReference("groups");
        groupKey = groupRef.push();
        groupID = groupKey.getKey();

        initializelocation = database.getReference("groups").child(groupID).child("locations");
        locationKey = initializelocation.push();
        locationID = locationKey.getKey();
        locationKey.setValue("Coordinate");      //<<<<<<<Change


        //Send coordinates to location marker tree
        locationMarker = database.getReference("location marker").child(locationID);
        locationMarker.setValue("Coordinate in marker tree");         //<<<<<<<Change

        groupRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //     Failed to read value
                toastMessage("Failed to alter database.");
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });

        buttonAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Attempting to add object to database.");
                String course = _Course.getText().toString();
                String starttime = _StartTime.getText().toString();
                String endtime = _EndTime.getText().toString();
                String numppl = _NumberOfPeople.getText().toString();

                if (!course.equals("")) {
                    groupRef.child(groupID).child("course").setValue(course);
                    toastMessage("Adding " + course + " to database...");
                    // reset the text
                    _Course.setText("");
                }
                if (!starttime.equals("")) {
                    groupRef.child(groupID).child("starttime").setValue(starttime);
                    toastMessage("Adding " + starttime + " to database...");
                    // reset the text
                    _StartTime.setText("");
                }
                if (!endtime.equals("")) {
                    groupRef.child(groupID).child("endtime").setValue(endtime);
                    toastMessage("Adding " + endtime + " to database...");
                    // reset the text
                    _EndTime.setText("");
                }
                if (!numppl.equals("")) {
                    groupRef.child(groupID).child("numppl").setValue(numppl);
                    toastMessage("Adding " + numppl + " to database...");
                    // reset the text
                    _NumberOfPeople.setText("");
                }
            }
        });


        //add a toast to show when successfully signed in
        Button btnCapen = (Button) findViewById(R.id.capen);

        btnCapen.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View v){

                //Intent startIntent = new Intent(getApplicationContext(), Capen.class);
                locationID = "Capen";
                groupRef.child(groupID).child("locations").setValue(locationID);
            }

        });

        Button btnLockwood = (Button) findViewById(R.id.lockwood);

        btnLockwood.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view){


                //Intent startIntent = new Intent(getApplicationContext(), LockWood.class);
                locationID = "Lockwood";
                groupRef.child(groupID).child("locations").setValue(locationID);
            }
        });

        Button btnSU = (Button) findViewById(R.id.StudentUnion);

        btnSU.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), StudentUnion.class);
                //Intent startIntent = new Intent(getApplicationContext(), StudentUnion.class);
                locationID = "Student Union";
                groupRef.child(groupID).child("location").setValue(locationID);
            }
        });

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}

