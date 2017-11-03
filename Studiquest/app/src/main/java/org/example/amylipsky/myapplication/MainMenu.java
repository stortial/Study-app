package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

//After GoogleSign In page (4 buttons: maps,logout,classes,groups)

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

//
//
        //if (getIntent().hasExtra("org.example.amylipsky.myapplication.SOMETHING")) {
        //TextView tv = (TextView) findViewById(R.id.textView3);

        // String text = getIntent().getExtras().getString("org.example.amylipsky.myapplication.SOMETHING");
        // tv.setText(text);

        //}
        //create groups class
        Button button1 = (Button) findViewById(R.id.creategroup);
        button1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CreateGroups.class);
                startActivity(startIntent);


            }


        });

        Button button2 = (Button) findViewById(R.id.googlemap);
        button2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), GoogleMaps.class);
                startActivity(startIntent);


            }
        });



    Button button3 = (Button) findViewById(R.id.button4);
       button3.setOnClickListener(new View.OnClickListener()

    {
//
//
        public void onClick (View v){
        Intent startIntent = new Intent(getApplicationContext(), MyClassesActivity.class);
        startActivity(startIntent);
//

    }
//
//
//
    });
//
//
//
//
}

    public void signOut(View v) {
        FirebaseAuth.getInstance().signOut();
        Intent myIntent = new Intent(MainMenu.this, GoogleSignIn.class);
        startActivity(myIntent);
        finish();
    }
}