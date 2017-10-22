package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

/**
 * Created by Melis on 10/7/2017.
 */

public class MyClassesActivity extends AppCompatActivity {


    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    final String _User = currentUser.getUid(); //get Uid from Auth


    ArrayList<String> courselist = new ArrayList<String>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myclasses_main);


        Button buttonAddClass = (Button) findViewById(R.id.addClasses);
        buttonAddClass.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SelectCourses.class);
                startActivity(startIntent);


            }


        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(_User).child("Courses");

        // Read from the database to list all courses in User
        myRef.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                //System.out.println(dataSnapshot.getKey());
                /// add to arraylist


                courselist.add(dataSnapshot.getKey());
                mAdapter.notifyDataSetChanged();

                // update list view
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
                Log.e("FirebaseListAdapter", "Listen was cancelled, no more updates will occur");
            }

            // ...
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        mAdapter = new MyAdapter(courselist);
        mRecyclerView.setAdapter(mAdapter);


    }

}


