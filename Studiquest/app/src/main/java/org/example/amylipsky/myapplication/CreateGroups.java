package org.example.amylipsky.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static org.example.amylipsky.myapplication.R.id.AddGroup;
import static org.example.amylipsky.myapplication.R.id.desc;


public class CreateGroups extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference groupRef;
    private DatabaseReference groupKey;
    private DatabaseReference initialize;
    private DatabaseReference initializelocation;
    private DatabaseReference locationKey;
    private DatabaseReference locationMarker;
    private String locationID;


    private FirebaseAuth.AuthStateListener mAuthListener;
   private EditText coursepre;
    private TimePicker _StartTime;
    private TimePicker _EndTime;
    private EditText descrip;
    private String groupID;
    private static final String TAG = "DataBase";

    Button button, prefixbtn;
    Button testing;
    private String theCourse = "";

    public EditText getDescrip() {
        return descrip;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);


//        Button backarr = (Button) findViewById(R.id.backbutton);
//        backarr.setOnClickListener(new View.OnClickListener() {
//
//
//            public void onClick(View v) {
//                Intent startIntent = new Intent(getApplicationContext(), MainMenu.class);
//                startActivity(startIntent);
//
//
//            }
//
//
//        });
        //locations button
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                final PopupMenu popupmenu = new PopupMenu(CreateGroups.this, button);
                popupmenu.getMenuInflater().inflate(R.menu.pop_up, popupmenu.getMenu());

                popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(CreateGroups.this, " " + item.getTitle(), Toast.LENGTH_LONG).show();
                        groupRef.child(groupID).child("locations").setValue(item.getTitle());
                        return true;
                    }


                });
                popupmenu.show();

            }
        });

        //MEL:prefix buton that lets u go to radiobtn class/upper left
        prefixbtn = (Button) findViewById(R.id.location);
        prefixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent startIntent = new Intent(getApplicationContext(), RadioBtn.class);
                startActivity(startIntent);


            }
        });

        // MEL: _Course=(EditText) findViewById(R.id.courseprefix);
        coursepre = (EditText) findViewById(R.id.courseprefix);
        _StartTime = (TimePicker) findViewById(R.id.TimePicker1);
        _EndTime = (TimePicker) findViewById(R.id.TimePicker2);
        //MEL:Numpler of people edit text
        descrip= (EditText) findViewById(desc);
        Button buttonAddGroup = (Button) findViewById(AddGroup);
        descrip.setTextColor(Color.WHITE);
       descrip.setSelection(descrip.length());

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        final String _User = currentUser.getUid(); //get Uid from Auth

        database = FirebaseDatabase.getInstance();
        // initialize = database.getReference("groups").child("Initialize Group");
        //initialize.setValue("true");
        groupRef = database.getReference("groups");
        groupKey = groupRef.push();
        groupID = groupKey.getKey();

        /*initializelocation = database.getReference("groups").child(groupID).child("locations");
        locationKey = initializelocation.push();
        locationID = locationKey.getKey();
        locationKey.setValue("Coordinate");      //<<<<<<<Change


        //Send coordinates to location marker tree
        locationMarker = database.getReference("location marker").child(locationID);
        locationMarker.setValue("Coordinate in marker tree");  */       //<<<<<<<Change

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
                String course = prefixbtn.getText().toString() + coursepre.getText().toString() ;
                //MEL: _Course.getText().toString()

                String starttime = "";
                String amPm = "";
                if(_StartTime.getHour() > 12){
                    starttime += (_StartTime.getHour() - 12);
                    amPm = "PM";
                } else {
                    starttime += _StartTime.getHour();
                    amPm = "AM";
                }
                starttime += ":";
                if(_StartTime.getMinute() < 10){
                    starttime += "0";
                }
                starttime += _StartTime.getMinute() + amPm;

                String endtime = "";
                if(_EndTime.getHour() > 12){
                    endtime += (_EndTime.getHour() - 12);
                    amPm = "PM";
                } else {
                    endtime += _EndTime.getHour();
                    amPm = "AM";
                }
                endtime += ":";
                if(_EndTime.getMinute() < 10){
                    endtime += "0";
                }
                endtime += _EndTime.getMinute() + amPm;
                //numberofpeople where purple text is
                String numppl = descrip.getText().toString();

                if (!course.equals("")) {
                    groupRef.child(groupID).child("course").setValue(course);
                    toastMessage("Adding " + course + " to database...");
                    // reset the text
                    //mel:_course
                    coursepre.setText("");
                }
                if (!starttime.equals("")) {
                    groupRef.child(groupID).child("starttime").setValue(starttime);
                    toastMessage("Adding " + starttime + " to database...");
                }
                if (!endtime.equals("")) {
                    groupRef.child(groupID).child("endtime").setValue(endtime);
                    toastMessage("Adding " + endtime + " to database...");
                }
                if (!numppl.equals("")) {
                    groupRef.child(groupID).child("numppl").setValue(numppl);
                    toastMessage("Adding " + numppl + " to database...");
                    // reset the text
                    //MEL: used to be _Numberofpeople
                    descrip.setText("");
                }
                if (!_User.equals("")) {
                    groupRef.child(groupID).child("User").setValue(_User);
                    //MEL: used to be _Numberofpeople
                    descrip.setText("");
                }
            }
        });
    }
    

        private void toastMessage(String message) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }


    }
