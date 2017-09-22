package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating buttons for login page
        Button button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.NewUser);

        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(), Main2Activity.class);
                //show info
                startIntent.putExtra("org.example.amylipsky.myapplication.SOMETHING", "Hello World");
                startActivity(startIntent);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent startIntent1 = new Intent(getApplicationContext(), Main3Activity.class);
                //show info
                startIntent1.putExtra("org.example.amylipsky.myapplication.SOMETHINGG", "Hello World");
                startActivity(startIntent1);


            }
        });


    }
}







