package org.example.amylipsky.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;



public class RadioBtn extends ActionBarActivity {
    private RadioGroup mFirstGroup;
    private RadioGroup mSecondGroup;
    private RadioGroup Gthree;
    private RadioGroup Gfour;
    private RadioGroup Gfive;
    private RadioGroup Gsix;
    private RadioGroup Gsevan;
    private RadioGroup Geight;
    private RadioGroup Gnine;
    private RadioGroup Gten;
    private RadioGroup Geleven;
    private RadioGroup Gtweleve;
    private RadioGroup Gthirteen;
    private RadioGroup Gfourteen;
    private RadioGroup Gfithteen;
    private RadioGroup Gsixteen;
    private RadioGroup Gsevanteen;
    private RadioGroup Geighteen;
    private RadioGroup Gninteen;
    private RadioGroup Gtwenety;
    private RadioGroup Gtwenetyone;
    private RadioGroup Gtwenetytwo;
    private RadioGroup Gtwenetythree;
    private RadioGroup Gtwenetyfour;
    private RadioGroup Gtwenetyfive;
    private RadioGroup Gtwenetysix;
    private RadioGroup Gtwenetysevan;
    private RadioGroup Gtwenetyeight;
    private RadioGroup Gtwenetynine;
    private RadioGroup Gthirty;
    private RadioGroup Gthirtyone;
    private RadioGroup Gthirtytwo;
    private RadioGroup Gthirtythree;
    private RadioGroup Gthirtyfour;
    private RadioGroup Gthirtyfive;
    private RadioGroup Gthirtysix;


    private boolean isChecking = true;
    private int mCheckedId = R.id.type1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn);

        mFirstGroup = (RadioGroup) findViewById(R.id.first_group);
        mSecondGroup = (RadioGroup) findViewById(R.id.second_group);
        Gthree = (RadioGroup) findViewById(R.id.third_group);
        Gfour = (RadioGroup) findViewById(R.id.forth_group_group);
        Gfive = (RadioGroup) findViewById(R.id.five_group);
        Gsix = (RadioGroup) findViewById(R.id.sixth_goup);
        Gsevan = (RadioGroup) findViewById(R.id.sevan_goup);
        Geight = (RadioGroup) findViewById(R.id.eight_goup);
        Gnine = (RadioGroup) findViewById(R.id.nine_goup);
        Gten = (RadioGroup) findViewById(R.id.ten_goup);
        Geleven = (RadioGroup) findViewById(R.id.eleven_goup);
        Gtweleve = (RadioGroup) findViewById(R.id.twelve_goup);
        Gthirteen = (RadioGroup) findViewById(R.id.thirteen_goup);
        Gfourteen = (RadioGroup) findViewById(R.id.fourteen_goup);
        Gfithteen = (RadioGroup) findViewById(R.id.fifteen_goup);
        Gsixteen = (RadioGroup) findViewById(R.id.sixteen_group);
        Gsevanteen = (RadioGroup) findViewById(R.id.sevanteen_group);
        Geighteen = (RadioGroup) findViewById(R.id.eighteen_group);
        Gninteen = (RadioGroup) findViewById(R.id.nineteen_group);
        Gtwenety = (RadioGroup) findViewById(R.id.twenety_group);
        Gtwenetyone = (RadioGroup) findViewById(R.id.twenetyone_group);
        Gtwenetytwo = (RadioGroup) findViewById(R.id.twenetytwo_group);
        Gtwenetythree = (RadioGroup) findViewById(R.id.twenetythree_group);
        Gtwenetyfour = (RadioGroup) findViewById(R.id.twenetyfour_group);
        Gtwenetyfive = (RadioGroup) findViewById(R.id.twenetyfive_group);
        Gtwenetysix = (RadioGroup) findViewById(R.id.twenetysix_group);
        Gtwenetysevan = (RadioGroup) findViewById(R.id.twenetysevan_group);
        Gtwenetyeight = (RadioGroup) findViewById(R.id.twenetyeight_group);
        Gtwenetynine = (RadioGroup) findViewById(R.id.twenetynine_group);
        Gthirty = (RadioGroup) findViewById(R.id.thirty_group);
        Gthirtyone = (RadioGroup) findViewById(R.id.thirtyone_group);
        Gthirtytwo = (RadioGroup) findViewById(R.id.thirtytwo_group);
        Gthirtythree = (RadioGroup) findViewById(R.id.thirtythree_group);
        Gthirtyfour = (RadioGroup) findViewById(R.id.thirtyfour_group);
        Gthirtyfive = (RadioGroup) findViewById(R.id.thirtyfive_group);
        Gthirtysix = (RadioGroup) findViewById(R.id.thirtysix_group);


        mFirstGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mSecondGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(), CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        mSecondGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(), CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });


        Gthree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });


        Gfour.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gfive.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gsix.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gsevan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Geight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });


        Gnine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });
        Gten.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Geleven.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtweleve.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gthirteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });


        Gfourteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });


        Gfithteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gsixteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gsevanteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Geighteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gninteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenety.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetyone.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetytwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetythree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gthirtyfour.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetyfive.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetysix.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetysevan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetyeight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gtwenetynine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gthirty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gthirtyone.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });


        Gthirtytwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });


        Gthirtythree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gthirtyfour.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gthirtyfive.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

        Gthirtysix.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                    Intent startIntent = new Intent(getApplicationContext(),CreateGroups.class);
                    startActivity(startIntent);

                }
                isChecking = true;
            }
        });

    }


    public void showType(View view) {
        if (mCheckedId == R.id.type1) {
            Toast.makeText(this, "AHI", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type2) {
            Toast.makeText(this, "AAS", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type3) {
            Toast.makeText(this, "AMS", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type4) {
            Toast.makeText(this, "APY", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type5) {
            Toast.makeText(this, "ANA", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type6) {
            Toast.makeText(this, "ARC", Toast.LENGTH_SHORT).show();
        }
    }
}