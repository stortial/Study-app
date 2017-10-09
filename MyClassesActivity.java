package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Melis on 10/7/2017.
 */

public class MyClassesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myclasses_main);

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
        Button buttonAddClass = (Button) findViewById(R.id.addClasses);
        buttonAddClass.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Click.class);
                startActivity(startIntent);


            }


        });


    }
}
