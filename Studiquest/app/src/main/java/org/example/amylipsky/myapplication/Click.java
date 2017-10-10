package org.example.amylipsky.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

//allows us to check off textboxes of what classes we are in
public class Click extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;


    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final String _User = currentUser.getUid(); //get Uid from Auth



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chec_box);
        final_text = (TextView) findViewById(R.id.finalResult);
        final_text.setEnabled(false);

        //FirebaseUser currentUser = mAuth.getCurrentUser();

        System.out.println("before the for loop " + selection.size());


        for (String Selections : selection) {
            System.out.println(Selections);
            DatabaseReference myRef = database.getReference("users").child(_User).child("Courses").child(Selections);
            myRef.setValue("true");


        }


    }

    public void selectedItem(View view) {


        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.check_boxx1:

                if (checked) {
                    selection.add("ARTHIST");
                } else {
                    selection.remove("ARTHIST");

                }
                break;


            case R.id.check_boxx:

                if (checked) {
                    selection.add("AAS");
                } else {
                    selection.remove("AAS");

                }
                break;
            case R.id.check_boxx2:

                if (checked) {
                    selection.add("ANAAnatomicalSciences");
                } else {
                    selection.remove("ANAAnatomicalSciences");

                }
                break;
            case R.id.check_boxx3:

                if (checked) {
                    selection.add("Architecture");
                } else {
                    selection.remove("Architecture");

                }
                break;
            case R.id.check_boxx4:

                if (checked) {
                    selection.add("Arabic");
                } else {
                    selection.remove("Arabic");

                }
                break;
            case R.id.check_boxx6:

                if (checked) {
                    selection.add("ART");
                } else {
                    selection.remove("ART");

                }
                break;
            case R.id.check_boxx7:

                if (checked) {
                    selection.add("AsianStudies");
                } else {
                    selection.remove("AsianStudies");

                }
                break;
            case R.id.check_boxx8:

                if (checked) {
                    selection.add("AmericanSignLanguage");
                } else {
                    selection.remove("AmericanSignLanguage");

                }
                break;
            case R.id.check_boxx9:

                if (checked) {
                    selection.add("BUS");
                } else {
                    selection.remove("BUS");

                }
                break;
            case R.id.check_boxx10:

                if (checked) {
                    selection.add("BiomedicalEngineering");
                } else {
                    selection.remove("BiomedicalEngineering");

                }
                break;
            case R.id.check_boxx11:

                if (checked) {
                    selection.add("BiologicalSciences");
                } else {
                    selection.remove("BiologicalSciences");

                }
                break;
            case R.id.check_boxx12:

                if (checked) {
                    selection.add("CDS");
                } else {
                    selection.remove("CDS");

                }
                break;
            case R.id.check_boxx13:

                if (checked) {
                    selection.add("ChemicalEngineering");
                } else {
                    selection.remove("ChemicalEngineering");

                }
                break;
            case R.id.check_boxx14:

                if (checked) {
                    selection.add("CEP");
                } else {
                    selection.remove("CEP");

                }
                break;
            case R.id.check_boxx15:

                if (checked) {
                    selection.add("Chemistry");
                } else {
                    selection.remove("Chemistry");

                }
                break;
            case R.id.check_boxx16:

                if (checked) {
                    selection.add("Chinese");
                } else {
                    selection.remove("Chinese");

                }
                break;
            case R.id.check_boxx17:

                if (checked) {
                    selection.add("CivilEngineering");
                } else {
                    selection.remove("CivilEngineering");

                }
                break;
            case R.id.check_boxx18:

                if (checked) {
                    selection.add("Classics");
                } else {
                    selection.remove("Classics");

                }
                break;
            case R.id.check_boxx19:

                if (checked) {
                    selection.add("ComparativeLiterature");
                } else {
                    selection.remove("ComparativeLiterature");

                }
                break;
            case R.id.check_boxx20:

                if (checked) {
                    selection.add("Communication");
                } else {
                    selection.remove("Communication");

                }
                break;
            case R.id.check_boxx21:

                if (checked) {
                    selection.add("CORAP");
                } else {
                    selection.remove("CORAP");

                }
                break;
            case R.id.check_boxx22:

                if (checked) {
                    selection.add("COMMUNNITYHLTH");
                } else {
                    selection.remove("COMMUNNITYHLTH");

                }
                break;
            case R.id.check_boxx23:

                if (checked) {
                    selection.add("CSE");
                } else {
                    selection.remove("CSE");

                }
                break;
            case R.id.check_boxx24:

                if (checked) {
                    selection.add("Dance");
                } else {
                    selection.remove("Dance");

                }
                break;
            case R.id.check_boxx25:

                if (checked) {
                    selection.add("MediaStudy");
                } else {
                    selection.remove("MediaStudy");

                }
                break;
            case R.id.check_boxx26:

                if (checked) {
                    selection.add("engapplisc");
                } else {
                    selection.remove("engapplisc");

                }
                break;
            case R.id.check_boxx27:

                if (checked) {
                    selection.add("Economics");
                } else {
                    selection.remove("Economics");

                }
                break;
            case R.id.check_boxx28:

                if (checked) {
                    selection.add("ElectricalEngineering");
                } else {
                    selection.remove("ElectricalEngineering");

                }
                break;
            case R.id.check_boxx29:

                if (checked) {
                    selection.add("EDULEADERSHIP");
                } else {
                    selection.remove("EDULEADERSHIP");

                }
                break;
            case R.id.check_boxx30:

                if (checked) {
                    selection.add("EnvironmentalDesign");
                } else {
                    selection.remove("EnvironmentalDesign");

                }
                break;
            case R.id.check_boxx31:

                if (checked) {
                    selection.add("ENGL");
                } else {
                    selection.remove("ENGL");

                }
                break;
            case R.id.check_boxx32:

                if (checked) {
                    selection.add("ExerciseScience");
                } else {
                    selection.remove("ExerciseScience");

                }
                break;
            case R.id.check_boxx33:

                if (checked) {
                    selection.add("ENGLASASECONDLANG");
                } else {
                    selection.remove("ENGLASASECONDLANG");

                }
                break;
            case R.id.check_boxx34:

                if (checked) {
                    selection.add("FRENCH");
                } else {
                    selection.remove("FRENCH");

                }
                break;
            case R.id.check_boxx35:

                if (checked) {
                    selection.add("GEO");
                } else {
                    selection.remove("GEO");

                }
                break;
            case R.id.check_boxx36:

                if (checked) {
                    selection.add("GERMAN");
                } else {
                    selection.remove("GERMAN");

                }
                break;
            case R.id.check_boxx37:

                if (checked) {
                    selection.add("GlobalGendertudies");
                } else {
                    selection.remove("GlobalGendertudies");

                }
                break;
            case R.id.check_boxx38:

                if (checked) {
                    selection.add("Geology");
                } else {
                    selection.remove("Geology");

                }
                break;
            case R.id.check_boxx39:

                if (checked) {
                    selection.add("GREEKANCIENT");
                } else {
                    selection.remove("GREEKANCIENT");

                }
                break;
            case R.id.check_boxx40:

                if (checked) {
                    selection.add("GREEKMODERN");
                } else {
                    selection.remove("GREEKMODERN");

                }
                break;
            case R.id.check_boxx41:

                if (checked) {
                    selection.add("hebrew");
                } else {
                    selection.remove("hebrew");

                }
                break;
            case R.id.check_boxx42:

                if (checked) {
                    selection.add("Hindi");
                } else {
                    selection.remove("Hindi");

                }
                break;
            case R.id.check_boxx43:

                if (checked) {
                    selection.add("History");
                } else {
                    selection.remove("History");

                }
                break;
            case R.id.check_boxx44:

                if (checked) {
                    selection.add("HonorsCollege");
                } else {
                    selection.remove("HonorsCollege");

                }
                break;
            case R.id.check_boxx45:

                if (checked) {
                    selection.add("IE");
                } else {
                    selection.remove("IE");

                }
                break;
            case R.id.check_boxx46:

                if (checked) {
                    selection.add("Italian");
                } else {
                    selection.remove("Italian");

                }
                break;
            case R.id.check_boxx47:

                if (checked) {
                    selection.add("JudaicStudies");
                } else {
                    selection.remove("History");

                }
                break;
            case R.id.check_boxx48:

                if (checked) {
                    selection.add("LegalSTUDIES");
                } else {
                    selection.remove("LegalSTUDIES");

                }
                break;
            case R.id.check_boxx49:

                if (checked) {
                    selection.add("Japanese");
                } else {
                    selection.remove("Japanese");

                }
                break;
            case R.id.check_boxx50:

                if (checked) {
                    selection.add("Korean");
                } else {
                    selection.remove("Korean");

                }
                break;
            case R.id.check_boxx51:

                if (checked) {
                    selection.add("LEARNINGANDINSTRUCT");
                } else {
                    selection.remove("LEARNINGANDINSTRUCT");

                }
                break;
            case R.id.check_boxx52:

                if (checked) {
                    selection.add("Latin");
                } else {
                    selection.remove("Latin");

                }
                break;
            case R.id.check_boxx53:

                if (checked) {
                    selection.add("Linguistics");
                } else {
                    selection.remove("Linguistics");

                }
                break;
            case R.id.check_boxx54:

                if (checked) {
                    selection.add("LatinaLatinoStudiesProgram");
                } else {
                    selection.remove("LatinaLatinoStudiesProgram");

                }
                break;
            case R.id.check_boxx55:

                if (checked) {
                    selection.add("MAE");
                } else {
                    selection.remove("MAE");

                }
                break;
            case R.id.check_boxx56:

                if (checked) {
                    selection.add("Millard");
                } else {
                    selection.remove("History");

                }
                break;
            case R.id.check_boxx57:

                if (checked) {
                    selection.add("MGA");
                } else {
                    selection.remove("MGA");

                }
                break;
            case R.id.check_boxx58:

                if (checked) {
                    selection.add("mgb");
                } else {
                    selection.remove("mgb");

                }
                break;
            case R.id.check_boxx59:

                if (checked) {
                    selection.add("ManagementEconomics");
                } else {
                    selection.remove("ManagementEconomics");

                }
                break;
            case R.id.check_boxx60:

                if (checked) {
                    selection.add("ManagementFinance");
                } else {
                    selection.remove("ManagementFinance");

                }
                break;
            case R.id.check_boxx61:

                if (checked) {
                    selection.add("GeneralManagemen");
                } else {
                    selection.remove("GeneralManagemen");

                }
                break;
            case R.id.check_boxx62:

                if (checked) {
                    selection.add("HMANAGEMENTINDUSTRIALRE");
                } else {
                    selection.remove("MANAGEMENTINDUSTRIALRE");

                }
                break;
            case R.id.check_boxx63:

                if (checked) {
                    selection.add("ManagementMarketing");
                } else {
                    selection.remove("ManagementMarketing");

                }
                break;
            case R.id.check_boxx64:

                if (checked) {
                    selection.add("MGO");
                } else {
                    selection.remove("MGO");

                }
                break;
            case R.id.check_boxx65:

                if (checked) {
                    selection.add("MGQ");
                } else {
                    selection.remove("MGQ");

                }
                break;
            case R.id.check_boxx67:

                if (checked) {
                    selection.add("MANAGEMENTANDPOLICY");
                } else {
                    selection.remove("MANAGEMENTANDPOLICY");

                }
                break;
            case R.id.check_boxx68:

                if (checked) {
                    selection.add("MICROANDIMM");
                } else {
                    selection.remove("MICROANDIMM");

                }
                break;
            case R.id.check_boxx69:

                if (checked) {
                    selection.add("MilitaryLeadership");
                } else {
                    selection.remove("MilitaryLeadership");

                }
                break;
            case R.id.check_boxx70:

                if (checked) {
                    selection.add("MedicalTechnology");
                } else {
                    selection.remove("MedicalTechnology");

                }
                break;
            case R.id.check_boxx71:

                if (checked) {
                    selection.add("Mathematics");
                } else {
                    selection.remove("Mathematics");

                }
                break;
            case R.id.check_boxx72:

                if (checked) {
                    selection.add("MusicTheatre");
                } else {
                    selection.remove("MusicTheatre");

                }
                break;
            case R.id.check_boxx73:

                if (checked) {
                    selection.add("MUSIC");
                } else {
                    selection.remove("MUSIC");

                }
                break;
            case R.id.check_boxx74:

                if (checked) {
                    selection.add("NURSE");
                } else {
                    selection.remove("NURSE");

                }
                break;
            case R.id.check_boxx75:

                if (checked) {
                    selection.add("TRADBSNURSING");
                } else {
                    selection.remove("TRADBSNURSING");

                }
                break;
            case R.id.check_boxx76:

                if (checked) {
                    selection.add("UNDERGRADNURSING");
                } else {
                    selection.remove("UNDERGRADNURSING");

                }
                break;
            case R.id.check_boxx77:

                if (checked) {
                    selection.add("Nutrition");
                } else {
                    selection.remove("Nutrition");

                }
                break;
            case R.id.check_boxx78:

                if (checked) {
                    selection.add("OT");
                } else {
                    selection.remove("OT");

                }
                break;
            case R.id.check_boxx79:

                if (checked) {
                    selection.add("Physiology");
                } else {
                    selection.remove("Physiology");

                }
                break;

            case R.id.check_boxx80:

                if (checked) {
                    selection.add("pharmacy");
                } else {
                    selection.remove("pharmacy");

                }
                break;
            case R.id.check_boxx82:

                if (checked) {
                    selection.add("Physics");
                } else {
                    selection.remove("Physics");

                }
                break;
            case R.id.check_boxx83:

                if (checked) {
                    selection.add("pharmcology");
                } else {
                    selection.remove("pharmcology");

                }
                break;
            case R.id.check_boxx84:

                if (checked) {
                    selection.add("polish");
                } else {
                    selection.remove("polish");

                }
                break;
            case R.id.check_boxx85:

                if (checked) {
                    selection.add("polishstudies");
                } else {
                    selection.remove("polishstudies");

                }
                break;
            case R.id.check_boxx86:

                if (checked) {
                    selection.add("politicalScience");
                } else {
                    selection.remove("politicalScience");

                }
                break;
            case R.id.check_boxx87:

                if (checked) {
                    selection.add("Psychology");
                } else {
                    selection.remove("Psychology");

                }
                break;
            case R.id.check_boxx88:

                if (checked) {
                    selection.add("publichealth");
                } else {
                    selection.remove("publichealth");

                }
                break;
            case R.id.check_boxx89:

                if (checked) {
                    selection.add("RecLIGIOUSTUDIES");
                } else {
                    selection.remove("RecLIGIOUSTUDIES");

                }
                break;
            case R.id.check_boxx90:

                if (checked) {
                    selection.add("ROMANCE");
                } else {
                    selection.remove("ROMANCE");

                }
                break;
            case R.id.check_boxx91:

                if (checked) {
                    selection.add("Russian");
                } else {
                    selection.remove("Russian");

                }
                break;
            case R.id.check_boxx92:

                if (checked) {
                    selection.add("Sociology");
                } else {
                    selection.remove("Sociology");

                }
                break;
            case R.id.check_boxx93:

                if (checked) {
                    selection.add("Spanish");
                } else {
                    selection.remove("Spanish");

                }
                break;
            case R.id.check_boxx94:

                if (checked) {
                    selection.add("SocialSciencesInterdisciplinary");
                } else {
                    selection.remove("SocialSciencesInterdisciplinary");

                }
                break;
            case R.id.check_boxx95:

                if (checked) {
                    selection.add("biostat");
                } else {
                    selection.remove("biostat");

                }
                break;

            case R.id.check_boxx97:

                if (checked) {
                    selection.add("Theatre");
                } else {
                    selection.remove("Theatre");

                }
                break;
            case R.id.check_boxx98:

                if (checked) {
                    selection.add("UndergraduateEducation");
                } else {
                    selection.remove("UndergraduateEducation");

                }
                break;
            case R.id.check_boxx99:

                if (checked) {
                    selection.add("UndergraduateCollege");
                } else {
                    selection.remove("UndergraduateCollege");

                }
                break;
            case R.id.check_boxx100:

                if (checked) {
                    selection.add("LearningCenter");
                } else {
                    selection.remove("LearningCenter");

                }
                break;
            case R.id.check_boxx101:

                if (checked) {
                    selection.add("VisualStudies");
                } else {
                    selection.remove("VisualStudies");

                }
                break;
            case R.id.check_boxx102:

                if (checked) {
                    selection.add("Yiddish");
                } else {
                    selection.remove("Yiddish");

                }
                break;


        }
    }


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


}