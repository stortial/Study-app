package org.example.amylipsky.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amylipsky on 9/23/17.
 */
//allows us to check off textboxes of what classes we are in
public class Click extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chec_box);
        final_text = (TextView) findViewById(R.id.finalResult);
        final_text.setEnabled(false);
    }

    public void selectedItem(View view) {


        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.check_boxx:

                if (checked) {
                    selection.add("CSE");
                } else {
                    selection.remove("CSE");

                }
                break;


            case R.id.check_boxx1:

                if (checked) {
                    selection.add("BUS");
                } else {
                    selection.remove("BUS");

                }
                break;
            case R.id.check_boxx2:

                if (checked) {
                    selection.add("COM");
                } else {
                    selection.remove("COM");

                }
                break;


        }


    }


    public void finalSelection(View view) {

        String final_course_selectio = "";

        for (String Selections : selection) {
            final_course_selectio = final_course_selectio + Selections + "\n";

        }

        final_text.setText(final_course_selectio);
        final_text.setEnabled(true);


    }
}
