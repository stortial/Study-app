package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import static org.example.amylipsky.myapplication.R.id.bt2;
import static org.example.amylipsky.myapplication.R.id.button4;

//After GoogleSign In page (4 buttons: maps,logout,classes,groups)
public class Main2Activity  extends AppCompatActivity {


    private double lat;
    private double longitude;
    private String provider;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


//
//
//        if (getIntent().hasExtra("org.example.amylipsky.myapplication.SOMETHING")) {
//            TextView tv = (TextView) findViewById(R.id.textView3);
//
//            String text = getIntent().getExtras().getString("org.example.amylipsky.myapplication.SOMETHING");
//            //putting text in text view
//            tv.setText(text);
//
//        }
        //create groups class
        Button button1 = (Button) findViewById(R.id.bt2);
        button1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), DataBase.class);
                startActivity(startIntent);


            }


        });

        Button button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Main5Activity.class);
                startActivity(startIntent);


            }
        });


        Button button6 = (Button) findViewById(R.id.groupss);
        button6.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Main6Activity.class);
                startActivity(startIntent);
            }



        });


        Button button3=(Button) findViewById(button4);
        button3.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MyClassesActivity.class);
                startActivity(startIntent);


            }



        });




    }





    public void signOut(View v){
        FirebaseAuth.getInstance().signOut();
        Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }






}



























