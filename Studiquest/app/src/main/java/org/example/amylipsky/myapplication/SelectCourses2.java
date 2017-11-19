package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/*         This class is apart of our add on features
       allows us to check off textboxes of what classes users are in


 */




public class SelectCourses2 extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;
    boolean isSelected = false;
    public static String stringforcourse;
/*
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final String _User = currentUser.getUid(); //get Uid from Auth
*/


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_courses2);
        //final_text = (TextView) findViewById(R.id.finalResult);
        //final_text.setEnabled(false);












        //FirebaseUser currentUser = mAuth.getCurrentUser();

        //System.out.println("before the for loop " + selection.size());

/*
        for (String Selections : selection) {
            System.out.println(Selections);
            //DatabaseReference myRef = database.getReference("users").child(_User).child("Courses").child(Selections);
            //myRef.setValue("true");
        }
*/

    }

    public void selectedItem(View view) {


        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.check_boxx1:

                if (checked) {
                    selection.add("AAS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("AAS");

                }
                break;


            case R.id.check_boxx2:

                if (checked) {
                    selection.add("AHI");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("AAS");

                }
                break;
            case R.id.check_boxx3:

                if (checked) {
                    selection.add("AMS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("AMS");

                }
                break;
            case R.id.check_boxx4:

                if (checked) {
                    selection.add("ANA");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ANS");

                }
                break;
            case R.id.check_boxx5:

                if (checked) {
                    selection.add("APY");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("APY");

                }
                break;
            case R.id.check_boxx6:

                if (checked) {
                    selection.add("ARC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ART");

                }
                break;
            case R.id.check_boxx7:

                if (checked) {
                    selection.add("ARI");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ARI");

                }
                break;
            case R.id.check_boxx8:

                if (checked) {
                    selection.add("ART");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ART");

                }
                break;
            case R.id.check_boxx9:

                if (checked) {
                    selection.add("AS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("AS");

                }
                break;
            case R.id.check_boxx10:

                if (checked) {
                    selection.add("ASL");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ASL");

                }
                break;
            case R.id.check_boxx11:

                if (checked) {
                    selection.add("BCH");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("BCH");

                }
                break;
            case R.id.check_boxx12:

                if (checked) {
                    selection.add("BE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("BE");

                }
                break;
            case R.id.check_boxx13:

                if (checked) {
                    selection.add("BIO");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("BIO");

                }
                break;
            case R.id.check_boxx14:

                if (checked) {
                    selection.add("BMS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("BMS");

                }
                break;
            case R.id.check_boxx15:

                if (checked) {
                    selection.add("CDS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CDS");

                }
                break;
            case R.id.check_boxx16:

                if (checked) {
                    selection.add("CE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CE");

                }
                break;
            case R.id.check_boxx17:

                if (checked) {
                    selection.add("CEP");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CEP");

                }
                break;
            case R.id.check_boxx18:

                if (checked) {
                    selection.add("CHB");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CHB");

                }
                break;
            case R.id.check_boxx19:

                if (checked) {
                    selection.add("CHE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CHE");

                }
                break;
            case R.id.check_boxx20:

                if (checked) {
                    selection.add("CHI");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CHI");

                }
                break;
            case R.id.check_boxx21:

                if (checked) {
                    selection.add("CIE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CIE");

                }
                break;
            case R.id.check_boxx22:

                if (checked) {
                    selection.add("CL");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CL");

                }
                break;
            case R.id.check_boxx23:

                if (checked) {
                    selection.add("COL");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("COL");

                }
                break;
            case R.id.check_boxx24:

                if (checked) {
                    selection.add("COM");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("COM");

                }
                break;
            case R.id.check_boxx25:

                if (checked) {
                    selection.add("CMP");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CPM");

                }
                break;
            case R.id.check_boxx26:

                if (checked) {
                    selection.add("CSE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("CSE");

                }
                break;
            case R.id.check_boxx27:

                if (checked) {
                    selection.add("DAC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("DAC");

                }
                break;
            case R.id.check_boxx28:

                if (checked) {
                    selection.add("DMS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("DMS");

                }
                break;
            case R.id.check_boxx29:

                if (checked) {
                    selection.add("EAS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("EAS");

                }
                break;
            case R.id.check_boxx30:

                if (checked) {
                    selection.add("ECO");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ECO");

                }
                break;
            case R.id.check_boxx31:

                if (checked) {
                    selection.add("EE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("EE");

                }
                break;
            case R.id.check_boxx32:

                if (checked) {
                    selection.add("ELP");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ELP");

                }
                break;
            case R.id.check_boxx33:

                if (checked) {
                    selection.add("END");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("END");

                }
                break;
            case R.id.check_boxx34:

                if (checked) {
                    selection.add("ENG");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ENG");

                }
                break;
            case R.id.check_boxx35:

                if (checked) {
                    selection.add("ES");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ES");

                }
                break;
            case R.id.check_boxx36:

                if (checked) {
                    selection.add("ESL");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ESL");

                }
                break;
            case R.id.check_boxx37:

                if (checked) {
                    selection.add("FR");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("FR");

                }
                break;
            case R.id.check_boxx38:

                if (checked) {
                    selection.add("GEO");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("GEO");

                }
                break;
            case R.id.check_boxx39:

                if (checked) {
                    selection.add("GER");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("GERT");

                }
                break;
            case R.id.check_boxx40:

                if (checked) {
                    selection.add("GGS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("GGS");

                }
                break;
            case R.id.check_boxx41:

                if (checked) {
                    selection.add("GLY");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("GLY");

                }
                break;
            case R.id.check_boxx42:

                if (checked) {
                    selection.add("GR");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("GR");

                }
                break;
            case R.id.check_boxx43:

                if (checked) {
                    selection.add("GRE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("GRE");

                }
                break;
            case R.id.check_boxx44:

                if (checked) {
                    selection.add("HEB");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("HEB");

                }
                break;
            case R.id.check_boxx45:

                if (checked) {
                    selection.add("HIN");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("HIN");

                }
                break;
            case R.id.check_boxx46:

                if (checked) {
                    selection.add("HIS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("HIS");

                }
                break;
            case R.id.check_boxx47:

                if (checked) {
                    selection.add("HON");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("HON");

                }
                break;
            case R.id.check_boxx48:

                if (checked) {
                    selection.add("IE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("IE");

                }
                break;
            case R.id.check_boxx49:

                if (checked) {
                    selection.add("ITA");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ITA");

                }
                break;
            case R.id.check_boxx50:

                if (checked) {
                    selection.add("JDS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("JDS");

                }
                break;
            case R.id.check_boxx51:

                if (checked) {
                    selection.add("JLS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("JLS");

                }
                break;
            case R.id.check_boxx52:

                if (checked) {
                    selection.add("JPN");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("JPN");

                }
                break;
            case R.id.check_boxx53:

                if (checked) {
                    selection.add("KOR");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("KOR");

                }
                break;
            case R.id.check_boxx54:

                if (checked) {
                    selection.add("LAI");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("LAI");

                }
                break;
            case R.id.check_boxx55:

                if (checked) {
                    selection.add("LAT");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("LAT");

                }
                break;
            case R.id.check_boxx56:

                if (checked) {
                    selection.add("LIN");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("LIN");

                }
                break;
            case R.id.check_boxx57:

                if (checked) {
                    selection.add("LLS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("LLS");

                }
                break;
            case R.id.check_boxx58:

                if (checked) {
                    selection.add("MAE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MAE");

                }
                break;
            case R.id.check_boxx59:

                if (checked) {
                    selection.add("MCH");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MCH");

                }
                break;
            case R.id.check_boxx60:

                if (checked) {
                    selection.add("MFC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MFC");

                }
                break;
            case R.id.check_boxx61:

                if (checked) {
                    selection.add("MGA");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGA");

                }
                break;
            case R.id.check_boxx62:

                if (checked) {
                    selection.add("MGB");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGB");

                }
                break;
            case R.id.check_boxx63:

                if (checked) {
                    selection.add("MFC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MFC");

                }
                break;
            case R.id.check_boxx64:

                if (checked) {
                    selection.add("MGG");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGG");

                }
                break;
            case R.id.check_boxx65:

                if (checked) {
                    selection.add("MGI");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGI");

                }
                break;
            case R.id.check_boxx66:

                if (checked) {
                    selection.add("MGM");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGM");
                }
                break;
            case R.id.check_boxx67:

                if (checked) {
                    selection.add("MGO");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGO");

                }
                break;
            case R.id.check_boxx68:

                if (checked) {
                    selection.add("MGQ");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGQ");

                }
                break;
            case R.id.check_boxx69:

                if (checked) {
                    selection.add("MGS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGS");

                }
                break;
            case R.id.check_boxx70:

                if (checked) {
                    selection.add("MGT");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MGT");

                }
                break;
            case R.id.check_boxx71:

                if (checked) {
                    selection.add("MIC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MIC");

                }
                break;
            case R.id.check_boxx72:

                if (checked) {
                    selection.add("MLS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MLS");

                }
                break;
            case R.id.check_boxx73:

                if (checked) {
                    selection.add("MT");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MT");

                }
                break;
            case R.id.check_boxx74:

                if (checked) {
                    selection.add("MTH");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MTH");

                }
                break;
            case R.id.check_boxx75:

                if (checked) {
                    selection.add("MTR");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MTR");

                }
                break;
            case R.id.check_boxx76:

                if (checked) {
                    selection.add("MUS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("MUS");

                }
                break;
            case R.id.check_boxx77:

                if (checked) {
                    selection.add("NBC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("NBC");

                }
                break;
            case R.id.check_boxx78:

                if (checked) {
                    selection.add("NBS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("NBS");

                }
                break;
            case R.id.check_boxx79:

                if (checked) {
                    selection.add("NMD");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("NMD");

                }
                break;

            case R.id.check_boxx80:

                if (checked) {
                    selection.add("NSG");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("NSG");

                }
                break;
            case R.id.check_boxx81:

                if (checked) {
                    selection.add("NTR");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("NTR");

                }
                break;
            case R.id.check_boxx82:

                if (checked) {
                    selection.add("OT");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("OT");

                }
                break;
            case R.id.check_boxx83:

                if (checked) {
                    selection.add("PGY");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PGY");

                }
                break;
            case R.id.check_boxx84:

                if (checked) {
                    selection.add("PHC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PHC");

                }
                break;
            case R.id.check_boxx85:

                if (checked) {
                    selection.add("PHI");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PHI");

                }
                break;
            case R.id.check_boxx86:

                if (checked) {
                    selection.add("PHM");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PHM");

                }
                break;
            case R.id.check_boxx87:

                if (checked) {
                    selection.add("PHY");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PHY");

                }
                break;
            case R.id.check_boxx88:

                if (checked) {
                    selection.add("PMY");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PMY");

                }
                break;
            case R.id.check_boxx89:

                if (checked) {
                    selection.add("POL");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("POL");

                }
                break;
            case R.id.check_boxx90:

                if (checked) {
                    selection.add("PS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PS");

                }
                break;
            case R.id.check_boxx91:

                if (checked) {
                    selection.add("PSC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PSC");

                }
                break;
            case R.id.check_boxx92:

                if (checked) {
                    selection.add("PSY");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PSY");

                }
                break;
            case R.id.check_boxx93:

                if (checked) {
                    selection.add("PUB");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("PUB");

                }
                break;
            case R.id.check_boxx94:

                if (checked) {
                    selection.add("REC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("REC");

                }
                break;
            case R.id.check_boxx95:

                if (checked) {
                    selection.add("RLL");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("RLL");


                }
                break;
            case R.id.check_boxx96:

                if (checked) {
                    selection.add("RSP");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("RSP");

                }
                break;


            case R.id.check_boxx97:

                if (checked) {
                    selection.add("RUS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("RUS");

                }
                break;
            case R.id.check_boxx98:

                if (checked) {
                    selection.add("SOC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("SOC");

                }
                break;
            case R.id.check_boxx99:

                if (checked) {
                    selection.add("SPA");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("SPA");

                }
                break;
            case R.id.check_boxx100:

                if (checked) {
                    selection.add("SSC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("SSC");

                }
                break;
            case R.id.check_boxx101:

                if (checked) {
                    selection.add("STA");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("STA");

                }
                break;
            case R.id.check_boxx102:

                if (checked) {
                    selection.add("TH");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("TH");

                }
                break;
            case R.id.check_boxx103:

                if (checked) {
                    selection.add("UE");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("UE");

                }
                break;
            case R.id.check_boxx104:

                if (checked) {
                    selection.add("UGC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("UGC");

                }
                break;
            case R.id.check_boxx105:

                if (checked) {
                    selection.add("ULC");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("ULC");

                }
                break;
            case R.id.check_boxx106:

                if (checked) {
                    selection.add("VS");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("VS");

                }
                break;
            case R.id.check_boxx107:

                if (checked) {
                    selection.add("YID");
                    isSelected=true;
                    break;
                } else {
                    selection.remove("YID");

                }
                break;


        }

        stringforcourse = selection.get(0);



        if (isSelected == true)
        {
            finish();

            //Intent startIntent = new Intent(getApplicationContext(), CreateGroups.class);
            //startActivity(startIntent);
        }

        isSelected = false;

    }






/*
    public void finalSelection(View view) {

        String final_course_selectio = "";
        System.out.println("before the for loop " + selection.size());

        for (String Selections : selection) {
            DatabaseReference myRef = database.getReference("users").child(_User).child("Courses").child(Selections);
            myRef.setValue("true");

            final_course_selectio = final_course_selectio + Selections + "\n";

        }

        final_text.setText(final_course_selectio);
        final_text.setEnabled(true);


    }

*/
}