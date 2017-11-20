package org.example.amylipsky.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.InputFilter;
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

    private String groupID;
    private static final String TAG = "DataBase";
    Button button, prefixbtn;
    Button testing;
    private String theCourse = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);

        final TimePicker tp = (TimePicker) this.findViewById(R.id.TimePicker2);
        tp.setIs24HourView(true);

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


                Intent startIntent = new Intent(getApplicationContext(), SelectCourses2.class);
                startActivity(startIntent);


            }
        });

        final EditText _Course=(EditText) findViewById(R.id.courseprefix);
        int maxLength1 = 3;
        _Course.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength1)});


        final EditText descrip = (EditText) findViewById(R.id.desc);
        Button buttonAddGroup = (Button) findViewById(AddGroup);
        descrip.setTextColor(Color.WHITE);
        descrip.setSelection(descrip.length());
        int maxLength = 50;
        descrip.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});




        database = FirebaseDatabase.getInstance();

        groupRef = database.getReference("groups");
        groupKey = groupRef.push();
        groupID = groupKey.getKey();



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
                String course = SelectCourses2.stringforcourse + _Course.getText().toString();
                String descriptions = descrip.getText().toString();

                if (!course.equals("")) {
                    groupRef.child(groupID).child("course").setValue(course);
                    toastMessage("Adding " + course + " to database...");

                }

                if (!descriptions.equals("")) {
                    groupRef.child(groupID).child("description").setValue(descriptions);

                }
                long endtime = 0;
                if(tp.getHour() < 24){
                    endtime += 60*60*1000*(tp.getHour());
                }
                if(tp.getMinute() < 10){
                    endtime += 60*1000*(tp.getMinute());
                }
               /* String endtime = "";
                if(tp.getHour() < 24){
                    endtime += (tp.getHour());

                }
                endtime += ":";
                if(tp.getMinute() < 10){
                    endtime += "0";
                }
                endtime += tp.getMinute();*/

                long StartTime = System.currentTimeMillis();
                groupRef.child(groupID).child("timestamp").setValue(StartTime + endtime);

                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                final String _User = currentUser.getUid(); //get Uid from Auth
                groupRef.child(groupID).child("User").setValue(_User);


                finish();
            }
        });
    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}