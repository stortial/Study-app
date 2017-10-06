package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import static org.example.amylipsky.myapplication.R.id.button4;

public class Main2Activity  extends AppCompatActivity {


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

        Button button1 = (Button) findViewById(R.id.bt2);
        button1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Main4Activity.class);
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

        Button button3=(Button) findViewById(button4);
        button3.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Click.class);
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



























