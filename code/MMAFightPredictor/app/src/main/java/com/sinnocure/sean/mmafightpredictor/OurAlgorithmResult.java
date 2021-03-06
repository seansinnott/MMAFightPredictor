package com.sinnocure.sean.mmafightpredictor;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class OurAlgorithmResult extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // get names of fighters from global class
        String fighterA = globalVariable.getNameFighterA();
        String fighterB = globalVariable.getNameFighterB();

        // all the info that will be shown to the user on the screen
        TextView textView = (TextView) findViewById(R.id.nametxt);
        TextView resultstxt = (TextView) findViewById(R.id.resulttxt);
        ImageView resultimg = (ImageView) findViewById(R.id.resultimg);
        TextView percent = (TextView) findViewById(R.id.percenttotal);

        // create array to hold the fighter totals after performing prediction e.g. 60/40 or 70/30
        int [] results;

        // calculate the winner if the user decided to give opinion
        if (globalVariable.isUserGivingOpinion()) {
            results = calculateWinnerDataAndOpinion();
        }
        // else calculate the winner if the user is just using data
        else {
            results = calculateWinnerDataOnly();
        }

        // if fighter A should beat fighter B
        if(results[0] > results[1]){
            resultstxt.setText(getString(R.string.winner_msg));
            textView.setText(fighterA);
            if (results[0] >= 100) {
                results[0] = 99;
            }
            percent.setText(Integer.toString(results[0]) + "%");
            resultimg.setImageResource(R.drawable.championbelt);
        }
        // else if fighter B should beat fighter A
        else if(results[1] > results[0]){
            resultstxt.setText(getString(R.string.winner_msg));
            textView.setText(fighterB);
            if (results[1] >= 100) {
                results[1] = 99;
            }
            percent.setText(Integer.toString(results[1]) + "%");
            resultimg.setImageResource(R.drawable.championbelt);
        }
        // else it is a draw
        else {
            resultstxt.setText(getString(R.string.draw_msg));
            textView.setText(getString(R.string.draw));
            resultimg.setImageResource(R.drawable.handshake);
        }
    }


    // method for predicting winner based on data from database and opinion from user
    public int [] calculateWinnerDataAndOpinion() {

        // create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // start the totals of both fighters on 50
        int totalFighterA = 50;
        int totalFighterB = 50;

        // get all the algorithm building info that the user entered and store it in variables
        final String fighterA = globalVariable.getNameFighterA();
        final String fighterB = globalVariable.getNameFighterB();

        // the following weights were the optimal weights that our genetic algorithm found
        final int reachWeight = 1;
        final int weightWeight = 3;
        final int heightWeight = 1;
        final int ageWeight = 1;
        final int betterStrikingWeight = 5;
        final int muchBetterStrikingWeight = 8;
        final int betterBJJWeight = 1;
        final int muchBetterBJJWeight = 8;
        final int betterWrestlingWeight = 1;
        final int muchBetterWrestlingWeight = 6;
        final int knockoutsWeight = 2;
        final int submissionsWeight = 1;
        final int streakWeight = 3;
        final int strikeOpinion = globalVariable.getUserChosenStrikingAdvantage();
        final int opinionBJJ = globalVariable.getUserChosenJiuJitsuAdvantage();
        final int wrestlingOpinion = globalVariable.getUserChosenWrestlingAdvantage();

        // Database object to retrieve fighter info from database
        DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());

        // retrieve all data about the two chosen fighters from the database and store it in these variables
        int reachA = dbhelper.getReach(fighterA);
        int reachB = dbhelper.getReach(fighterB);
        int heightA = dbhelper.getHeight(fighterA);
        int heightB = dbhelper.getHeight(fighterB);
        int weightA = dbhelper.getWeight(fighterA);
        int weightB = dbhelper.getWeight(fighterB);
        int ageA = dbhelper.getAge(fighterA);
        int ageB = dbhelper.getAge(fighterB);
        int koA = dbhelper.getNumKos(fighterA);
        int koB = dbhelper.getNumKos(fighterB);
        int kodA = dbhelper.getNumKnockedOut(fighterA);
        int kodB = dbhelper.getNumKnockedOut(fighterB);
        int subA = dbhelper.getNumSubs(fighterA);
        int subB = dbhelper.getNumSubs(fighterB);
        int subdA = dbhelper.getNumSubbed(fighterA);
        int subdB = dbhelper.getNumSubbed(fighterB);
        int winstreakA = dbhelper.getWinstreak(fighterA);
        int winstreakB = dbhelper.getWinstreak(fighterB);
        int losestreakA = dbhelper.getLosestreak(fighterA);
        int losestreakB = dbhelper.getLosestreak(fighterB);


        // THE GENETIC ALGORITHM'S PREDICTION ALGORITHM USING DATA & OPINION:.......................

        // calculate reach
        if (reachA > reachB) {
            if ( (reachA - reachB) >= 2) {
                totalFighterA += reachWeight;
                totalFighterB -= reachWeight;
            }
        }
        if (reachB > reachA) {
            if ( (reachB - reachA) >= 2) {
                totalFighterA -= reachWeight;
                totalFighterB += reachWeight;
            }
        }


        // calculate weight
        if (weightA > weightB) {
            if ( (weightA - weightB) >= 5) {
                totalFighterA += weightWeight;
                totalFighterB -= weightWeight;
            }
        }
        if (weightB > weightA) {
            if ( (weightB - weightA) >= 5) {
                totalFighterA -= weightWeight;
                totalFighterB += weightWeight;
            }
        }

        // calculate height
        if (heightA > heightB) {
            if ( (heightA - heightB) >= 5) {
                totalFighterA += heightWeight;
                totalFighterB -= heightWeight;
            }
        }
        if (heightB > heightA) {
            if ( (heightB - heightA) >= 5) {
                totalFighterA -= heightWeight;
                totalFighterB += heightWeight;
            }
        }

        // calculate age
        boolean badAgeFighterA = false;
        boolean badAgeFighterB = false;
        if (ageA >= 35 || ageA <= 23) {
            badAgeFighterA = true;
            totalFighterA -= ageWeight;
            totalFighterB += ageWeight;
        }

        if (ageB >= 35 || ageB <= 23) {
            badAgeFighterB = true;
            totalFighterA += ageWeight;
            totalFighterB -= ageWeight;
        }
        if (badAgeFighterA && !badAgeFighterB) {
            totalFighterA -= ageWeight;
            totalFighterB += ageWeight;
        }
        if (badAgeFighterB && !badAgeFighterA) {
            totalFighterA += ageWeight;
            totalFighterB -= ageWeight;
        }

        // calculate striking
        if (strikeOpinion == 0) { // fighter A has much better striking
            totalFighterA += muchBetterStrikingWeight;
            totalFighterB -= muchBetterStrikingWeight;
        }
        if (strikeOpinion == 1) { // fighter A has better striking
            totalFighterA += betterStrikingWeight;
            totalFighterB -= betterStrikingWeight;
        }
        if (strikeOpinion == 3) { // fighter B has better striking
            totalFighterA -= betterStrikingWeight;
            totalFighterB += betterStrikingWeight;
        }
        if (strikeOpinion == 4) { // fighter B has much better striking
            totalFighterA -= muchBetterStrikingWeight;
            totalFighterB += muchBetterStrikingWeight;
        }

        // calculate jiu jitsu
        if (opinionBJJ == 0) { // fighter A has much better jiu jitsu
            totalFighterA += muchBetterBJJWeight;
            totalFighterB -= muchBetterBJJWeight;
        }
        if (opinionBJJ == 1) { // fighter A has better jiu jitsu
            totalFighterA += betterBJJWeight;
            totalFighterB -= betterBJJWeight;
        }
        if (opinionBJJ == 3) { // fighter B has better jiu jitsu
            totalFighterA -= betterBJJWeight;
            totalFighterB += betterBJJWeight;
        }
        if (opinionBJJ == 4) { // fighter B has much better jiu jitsu
            totalFighterA -= muchBetterBJJWeight;
            totalFighterB += muchBetterBJJWeight;
        }

        // calculate wrestling
        if (wrestlingOpinion == 0) { // fighter A has much better wrestling
            totalFighterA += muchBetterWrestlingWeight;
            totalFighterB -= muchBetterWrestlingWeight;
        }
        if (wrestlingOpinion == 1) { // fighter A has better wrestling
            totalFighterA += betterWrestlingWeight;
            totalFighterB -= betterWrestlingWeight;
        }
        if (wrestlingOpinion == 3) { // fighter B has better wrestling
            totalFighterA -= betterWrestlingWeight;
            totalFighterB += betterWrestlingWeight;
        }
        if (wrestlingOpinion == 4) { // fighter B has much better wrestling
            totalFighterA -= muchBetterWrestlingWeight;
            totalFighterB += muchBetterWrestlingWeight;
        }


        // calculate knockouts
        if (kodA >= 4) {
            totalFighterA -= knockoutsWeight;
            totalFighterB += knockoutsWeight;
        }
        if (kodB >= 4) {
            totalFighterA += knockoutsWeight;
            totalFighterB -= knockoutsWeight;
        }
        if (koA >= 3 && kodB >= 3) {
            totalFighterA += knockoutsWeight;
            totalFighterB -= knockoutsWeight;
        }
        if (koB >= 3 && kodA >= 3) {
            totalFighterA -= knockoutsWeight;
            totalFighterB += knockoutsWeight;
        }


        // calculate submissions
        if (subA >= 3 && subdB >= 3) {
            totalFighterA += submissionsWeight;
            totalFighterB -= submissionsWeight;
        }
        if (subB >= 3 && subdA >= 3) {
            totalFighterA -= submissionsWeight;
            totalFighterB += submissionsWeight;
        }

        // calculate win/lose streaks
        if (winstreakA == 1) {
            totalFighterA += streakWeight;
            totalFighterB -= streakWeight;
        }
        if (winstreakB == 1) {
            totalFighterB += streakWeight;
            totalFighterA -= streakWeight;
        }
        if (losestreakA == 1) {
            totalFighterB += streakWeight;
            totalFighterA -= streakWeight;
        }
        if (losestreakB == 1) {
            totalFighterA += streakWeight;
            totalFighterB -= streakWeight;
        }

        // END OF ALGORITHM FOR DATA & OPINION......................................................
        return new int[]{totalFighterA, totalFighterB};
    }



    // method for predicting winner based on data only, no user opinion at all
    public int [] calculateWinnerDataOnly() {

        // create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // start the totals of both fighters on 50
        int totalFighterA = 50;
        int totalFighterB = 50;

        // get all the algorithm building info that the user entered and store it in variables
        final String fighterA = globalVariable.getNameFighterA();
        final String fighterB = globalVariable.getNameFighterB();

        // the following weights were the optimal weights that our genetic algorithm found
        final int reachWeight = 5;
        final int weightWeight = 8;
        final int heightWeight = 3;
        final int ageWeight = 1;
        final int knockoutsWeight = 4;
        final int submissionsWeight = 11;
        final int winStreakWeight = 6;
        final int loseStreakWeight = 9;

        // Ensure database is on user's phone
        DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());
        try {
            dbhelper.createDatabaseOnDevice();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // retrieve all data about the two chosen fighters from the database and store it in these variables
        int reachA = dbhelper.getReach(fighterA);
        int reachB = dbhelper.getReach(fighterB);
        int heightA = dbhelper.getHeight(fighterA);
        int heightB = dbhelper.getHeight(fighterB);
        int weightA = dbhelper.getWeight(fighterA);
        int weightB = dbhelper.getWeight(fighterB);
        int ageA = dbhelper.getAge(fighterA);
        int ageB = dbhelper.getAge(fighterB);
        int koA = dbhelper.getNumKos(fighterA);
        int koB = dbhelper.getNumKos(fighterB);
        int kodA = dbhelper.getNumKnockedOut(fighterA);
        int kodB = dbhelper.getNumKnockedOut(fighterB);
        int subA = dbhelper.getNumSubs(fighterA);
        int subB = dbhelper.getNumSubs(fighterB);
        int subdA = dbhelper.getNumSubbed(fighterA);
        int subdB = dbhelper.getNumSubbed(fighterB);
        int winstreakA = dbhelper.getWinstreak(fighterA);
        int winstreakB = dbhelper.getWinstreak(fighterB);
        int losestreakA = dbhelper.getLosestreak(fighterA);
        int losestreakB = dbhelper.getLosestreak(fighterB);


        // THE GENETIC ALGORITHM'S PREDICTION ALGORITHM USING DATA & OPINION:.......................

        // calculate reach
        if (reachA > reachB) {
            if ( (reachA - reachB) >= 2) {
                totalFighterA += reachWeight;
                totalFighterB -= reachWeight;
            }
        }
        if (reachB > reachA) {
            if ( (reachB - reachA) >= 2) {
                totalFighterA -= reachWeight;
                totalFighterB += reachWeight;
            }
        }

        // calculate weight
        if (weightA > weightB) {
            if ( (weightA - weightB) >= 5) {
                totalFighterA += weightWeight;
                totalFighterB -= weightWeight;
            }
        }
        if (weightB > weightA) {
            if ( (weightB - weightA) >= 5) {
                totalFighterA -= weightWeight;
                totalFighterB += weightWeight;
            }
        }

        // calculate height
        if (heightA > heightB) {
            if ( (heightA - heightB) >= 5) {
                totalFighterA += heightWeight;
                totalFighterB -= heightWeight;
            }
        }
        if (heightB > heightA) {
            if ( (heightB - heightA) >= 5) {
                totalFighterA -= heightWeight;
                totalFighterB += heightWeight;
            }
        }

        // calculate age
        boolean badAgeFighterA = false;
        boolean badAgeFighterB = false;
        if (ageA >= 35 || ageA <= 23) {
            badAgeFighterA = true;
            totalFighterA -= ageWeight;
            totalFighterB += ageWeight;
        }

        if (ageB >= 35 || ageB <= 23) {
            badAgeFighterB = true;
            totalFighterA += ageWeight;
            totalFighterB -= ageWeight;
        }
        if (badAgeFighterA && !badAgeFighterB) {
            totalFighterA -= ageWeight;
            totalFighterB += ageWeight;
        }
        if (badAgeFighterB && !badAgeFighterA) {
            totalFighterA += ageWeight;
            totalFighterB -= ageWeight;
        }

        // calculate knockouts
        if (kodA >= 4) {
            totalFighterA -= knockoutsWeight;
            totalFighterB += knockoutsWeight;
        }
        if (kodB >= 4) {
            totalFighterA += knockoutsWeight;
            totalFighterB -= knockoutsWeight;
        }
        if (koA >= 3 && kodB >= 3) {
            totalFighterA += knockoutsWeight;
            totalFighterB -= knockoutsWeight;
        }
        if (koB >= 3 && kodA >= 3) {
            totalFighterA -= knockoutsWeight;
            totalFighterB += knockoutsWeight;
        }

        // calculate submissions
        if (subA >= 3 && subdB >= 3) {
            totalFighterA += submissionsWeight;
            totalFighterB -= submissionsWeight;
        }
        if (subB >= 3 && subdA >= 3) {
            totalFighterA -= submissionsWeight;
            totalFighterB += submissionsWeight;
        }

        // calculate win/lose streaks
        if (winstreakA == 1) {
            totalFighterA += winStreakWeight;
            totalFighterB -= winStreakWeight;
        }
        if (winstreakB == 1) {
            totalFighterB += winStreakWeight;
            totalFighterA -= winStreakWeight;
        }
        if (losestreakA == 1) {
            totalFighterB += loseStreakWeight;
            totalFighterA -= loseStreakWeight;
        }
        if (losestreakB == 1) {
            totalFighterA += loseStreakWeight;
            totalFighterB -= loseStreakWeight;
        }

        // END OF ALGORITHM FOR DATA ONLY...........................................................
        return new int[]{totalFighterA, totalFighterB};
    }


    public void onClickReturnHomeButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
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
            Intent intent = new Intent(OurAlgorithmResult.this, Contact.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
        }
        if(id == R.id.helpbutt){
            Intent intent = new Intent(OurAlgorithmResult.this, Welcome1.class);
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
