package com.sinnocure.sean.mmafightpredictor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChooseFighters extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerFighterA;
    Spinner spinnerFighterB;
    String division;
    String fighterA;
    String fighterB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_fighters);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Drop Down Menu (Spinner) for selecting weight division of fighters and fighter names
        Spinner weightSpinner = (Spinner) findViewById(R.id.weight_division_spinner);
        weightSpinner.setOnItemSelectedListener(ChooseFighters.this);

        // initialise the weights drop down menu
        List<String> weightDivisions = new ArrayList<String>();
        weightDivisions.add("Flyweight");
        weightDivisions.add("Bantamweight");
        weightDivisions.add("Featherweight");
        weightDivisions.add("Lightweight");
        weightDivisions.add("Welterweight");
        weightDivisions.add("Middleweight");
        weightDivisions.add("Light Heavyweight");
        weightDivisions.add("Heavyweight");
        weightDivisions.add("Women's Strawweight");
        weightDivisions.add("Women's Bantamweight");

        // prepend menu header to list of weights
        // use value from strings.xml rather than a hardcoded value to allow for translation into other languages
        weightDivisions.add(0, getString(R.string.weight_division));

        // create adapter for weights drop down menu
        ArrayAdapter<String> weightAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, weightDivisions){
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(Color.RED);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        // create the spinner with the weight divisions as options
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightSpinner.setAdapter(weightAdapter);


        // initialise spinner for drop down menu of names for fighter A
        spinnerFighterA = (Spinner) findViewById(R.id.fighter_a_spinner);
        spinnerFighterA.setOnItemSelectedListener(ChooseFighters.this);

        // initialise spinner for drop down menu of names for fighter B
        spinnerFighterB = (Spinner) findViewById(R.id.fighter_b_spinner);
        spinnerFighterB.setOnItemSelectedListener(ChooseFighters.this);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());

        //create globalVariable to work with getters and setters from GlobalClass
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // create spinner object to be used as needed depending on which spinner object is selected
        Spinner spinner = (Spinner) adapterView;

        // if the user has selected the spinner which contains weight divisions as the options
        if (spinner.getId() == R.id.weight_division_spinner) {
            // get the weight division which they have selected
            division = adapterView.getItemAtPosition(i).toString();

            // select names of fighters in database in user's chosen weight division
            // and make them the options for the spinner for selecting the name of fighter A
            List<String> firstFighterNameList = dbHelper.getFighterABasedOnWeight(division);

            // prepend the title/hint for the spinner to the list of names so the user
            // knows what that drop down menu contains.. it cannot be selected as an option
            // use value from strings.xml rather than a hardcoded value to allow for translation into other languages
            firstFighterNameList.add(0, getString(R.string.first_fighter));

            // create adapter for first fighter name drop down menu
            ArrayAdapter<String> firstFighterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, firstFighterNameList){

                // prevent the title of the spinner from being a selectable option for the user
                @Override
                public boolean isEnabled(int position) {
                    return position != 0;
                }

                // make the colour of the title of the spinner different to all the selectable options
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        tv.setTextColor(Color.RED);
                    }
                    else {
                        tv.setTextColor(Color.BLACK);
                    }
                    return view;
                }
            };

            // create the spinner with the names of fighters in the user's selected division as options
            firstFighterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFighterA.setAdapter(firstFighterAdapter);
        }

        // if the user has already chosen a weight division and is now selecting the first fighter's name
        else if (spinner.getId() == R.id.fighter_a_spinner){
            // get the name of the fighter which they have selected
            fighterA = adapterView.getItemAtPosition(i).toString();

            // set it in the global class
            globalVariable.setNameFighterA(fighterA);

            // select names of fighters in database in user's chosen weight division except
            // the name which they have already chosen as fighter A and make them
            // the options for the spinner for selecting the name of fighter B
            List<String> secondFighterNameList = dbHelper.getFighterBBasedOnA(division, fighterA);

            // prepend the title/hint for the spinner to the list of names so the user
            // knows what that drop down menu contains.. it cannot be selected as an option
            // use value from strings.xml rather than a hardcoded value to allow for translation into other languages
            secondFighterNameList.add(0, getString(R.string.second_fighter));

            // create adapter for second fighter name drop down menu
            ArrayAdapter<String> secondFighterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, secondFighterNameList){
                // prevent the title of the spinner from being a selectable option for the user
                @Override
                public boolean isEnabled(int position) {
                    return position != 0;
                }

                // make the colour of the title of the spinner different to all the selectable options
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        tv.setTextColor(Color.RED);
                    }
                    else {
                        tv.setTextColor(Color.BLACK);
                    }
                    return view;
                }
            };

            // create the spinner with the names of fighters in the user's selected division
            // (except the name of fighter A) as options
            secondFighterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFighterB.setAdapter(secondFighterAdapter);
        }

        // the user has chosen weight division and name of first fighter so now get name of second fighter
        else if (spinner.getId() == R.id.fighter_b_spinner) {
            // get the name of the fighter which they have selected
            fighterB = adapterView.getItemAtPosition(i).toString();

            // set it in the global class
            globalVariable.setNameFighterB(fighterB);
        }

    }


    // method needed in order to implement AdapterView.OnItemSelectedListener
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // depending on what mode the user has chosen (Create Their Own Algorithm/Use Our Algorithm)
    // clicking next will bring them to different activities
    public void onClickChooseFightersNext(View view) {

        // ensure that the user has filled out all required fields before moving to next screen
        if (division.equals(getString(R.string.weight_division))
                || fighterA.equals(getString(R.string.first_fighter))
                || fighterB.equals(getString(R.string.second_fighter))) {
            // if they haven't filled out all fields, give them a warning message
            Toast.makeText(this, getString(R.string.choose_fighters_toast), Toast.LENGTH_SHORT).show();
        }
        else {

            //create globalVariable to work with getters and setters from GlobalClass..
            final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

            // reset any values based on opinion that were changed in a previous prediction
            globalVariable.resetAllValues();

            // if user is building their own algorithm, after they click next here,
            // send them to the screen where they can create an algorithm using sliders
            if (globalVariable.isUserChoseToBuildAlgorithm()) {
                Intent intent = new Intent(this, CreateAlgorithm.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
            }
            // else, the user is not building their own algorithm and are using our algorithm, so when they
            // click next, send them to the activity where they will be asked whether or not they want to
            // give their opinion on the fighter's skills
            else {
                Intent intent = new Intent(this, GiveOpinionOrNot.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
            overridePendingTransition(R.anim.backslidein, R.anim.backslideout);
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.contactbutt) {
            Intent intent = new Intent(ChooseFighters.this, Contact.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
        }
        if(id == R.id.helpbutt){
            Intent intent = new Intent(ChooseFighters.this, Welcome1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.upfrombottom, R.anim.outtop);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.backslidein, R.anim.backslideout);
    }
}




































