package org.example.amylipsky.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        if (getIntent().hasExtra("org.example.amylipsky.myapplication.SOMETHING")) {
            TextView tv = (TextView) findViewById(R.id.editText);

            String text = getIntent().getExtras().getString("org.example.amylipsky.myapplication.SOMETHING");
            //putting text in text view
            tv.setText(text);

        }

    }
}

