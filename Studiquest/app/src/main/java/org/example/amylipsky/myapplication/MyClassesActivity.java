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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Melis on 10/7/2017.
 */

public class MyClassesActivity extends AppCompatActivity {


    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final String _User = currentUser.getUid(); //get Uid from Auth

    public static class MyPair {
        private final String key;
        private final boolean value;

        public MyPair(String aKey, boolean aValue) {
            key = aKey;
            value = aValue;
        }

        public String key() {
            return key;
        }

        public boolean value() {
            return value;
        }

    }




    ArrayList<MyPair> courselist = new ArrayList<MyPair>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myclasses_main);

        Button backarr =(Button) findViewById(R.id.backbutton);
        backarr.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(startIntent);


            }


        });



        Button buttonAddClass = (Button) findViewById(R.id.addClasses);
        buttonAddClass.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SelectCourses.class);
                startActivity(startIntent);


            }


        });

        Button buttonRemoveClass = (Button) findViewById(R.id.removeClass);
        buttonRemoveClass.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Iterator<MyPair> iter = courselist.iterator();
                while(iter.hasNext()) {
                    MyPair pair = iter.next();
                    if (pair.value) {
                        DatabaseReference myRef = database.getReference("users").child(_User).child("Courses").child(pair.key);
                        myRef.removeValue();
                        iter.remove();
                    }
                }
                mAdapter.notifyDataSetChanged();

            }


        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(_User).child("Courses");

        // Read from the database to list all courses in User
        myRef.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                System.out.println(dataSnapshot.getKey());
                /// add to arraylist
                courselist.add(new MyPair(dataSnapshot.getKey(), false));
                Collections.sort(courselist, new Comparator<MyPair>() {
                    @Override
                    public int compare(MyPair pair1, MyPair pair2) {
                        return pair1.key.compareTo(pair2.key);
                    }
                });
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


